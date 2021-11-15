package kr.co.bunnyfoot.bunnyfoot.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import kr.co.bunnyfoot.bunnyfoot.config.QuestionConfig;
import kr.co.bunnyfoot.bunnyfoot.dto.BbtiResDto;
import kr.co.bunnyfoot.bunnyfoot.dto.MySlackSendDto;
import kr.co.bunnyfoot.bunnyfoot.dto.PredictResDto;
import kr.co.bunnyfoot.bunnyfoot.dto.QuestionDto;
import kr.co.bunnyfoot.bunnyfoot.dto.ScoreDto;
import kr.co.bunnyfoot.bunnyfoot.dto.SlackSendDto;
import kr.co.bunnyfoot.bunnyfoot.feign.PredictClient;
import kr.co.bunnyfoot.bunnyfoot.feign.SlackClient;
import kr.co.bunnyfoot.bunnyfoot.googlaanalytics.GoogleAnalyticsReporting;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="*", allowedHeaders="*")
public class BunnyFootController {
  
  @Autowired
  private AmazonS3Client amazonS3Client;
  
  @Autowired
  private PredictClient predictClient;
  
  @Autowired
  private SlackClient slackClient;
  
  @Autowired
  private GoogleAnalyticsReporting googleAnalyticsReporting;
  
  @Autowired
  private QuestionConfig questionConfig;
  
  @Value("${cloud.aws.s3.bucket}")
  private String bucket;
    
  
  @PostMapping("bbti")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "answers", value = "answers", dataType = "string", paramType = "form", example = "0,0,0,0,0,0,0,0,0", required = true),
    @ApiImplicitParam(name = "image", value = "image", dataType = "file", paramType = "form", required = true)
  })
  public BbtiResDto getBbti(
      @RequestPart(value = "answers", required = true) String answers,
      @RequestPart(value = "image", required = false) MultipartFile image) throws Exception {
    BbtiResDto result = new BbtiResDto();
    
    if(!ObjectUtils.isEmpty(image)) {
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
      File imageFile = new File("home/ubuntu/image/" + df.format(new Date()) + ".png"); 
      
      if(imageFile.createNewFile()) { 
    	try (FileOutputStream fos = new FileOutputStream(imageFile)) { 
          fos.write(image.getBytes()); 
        } 
      }
      
      amazonS3Client.putObject(new PutObjectRequest(bucket, df.format(new Date()), imageFile).withCannedAcl(CannedAccessControlList.PublicRead));

      if(imageFile.exists()) {
    	  imageFile.delete();
      }
      
      try {
        PredictResDto predictRes = predictClient.predict(image);
        if(predictRes.getProbability() < 0.3) {      
          result.setPredict("NORMAL");
        }
        else if(predictRes.getProbability() < 0.5) {      
          result.setPredict("WATCH");
        }
        else if(predictRes.getProbability() < 0.7) {      
          result.setPredict("WARNING");
        }
        else {      
          result.setPredict("DANGER");
        }
      }
      catch (Exception e) {
        result.setPredict("ERROR");
        exceptionHandeler(e);
      }
    }
    
    Map<String, QuestionDto> questions = questionConfig.getQuestion();
    String[] answerList = answers.split(",");
    Integer maxScore;
    Integer dodoScore = 0;
    Integer inssaScore = 0;
    Integer agyoScore = 0;
    Integer sundingScore = 0;
        
    for(int i = 0; i < 10; i++) {
    	ScoreDto score = null;
    	if(answerList[i].equals("0")) {
    		score = questions.get(Integer.toString(i + 1)).getTrueScore();
    	} else {
    		score = questions.get(Integer.toString(i + 1)).getFalseScore();
    	}
    	dodoScore += score.getDodo();
    	inssaScore += score.getInssa();
    	agyoScore += score.getAgyo();
    	sundingScore += score.getSunding();
    }
    
	maxScore = dodoScore;
	result.setBbti("DODO");
    if(maxScore < inssaScore) {
    	maxScore = inssaScore;
    	result.setBbti("INSSA");
    }
    if(maxScore < agyoScore) {
    	maxScore = agyoScore;
    	result.setBbti("AGYO");
    }
    if(maxScore < sundingScore) {
    	maxScore = sundingScore;
    	result.setBbti("SUNDING");
    }
    
    return result;
  }
  
  @GetMapping("pageView")
  public String getPageView() {
    return googleAnalyticsReporting.getPageView();
  }
  
  @PostMapping("sendSlackMsg")
  public String sendSlackMsg(@RequestBody MySlackSendDto mySlackSend) {
    SlackSendDto slackSend = new SlackSendDto();
    slackSend.setText(mySlackSend.getMsg());
    
    if(mySlackSend.getChannel().equals("welcome")) {      
      slackClient.sendSlackMsgToWelcome(slackSend);
    }
    else if(mySlackSend.getChannel().equals("error")){
      slackClient.sendSlackMsgToError(slackSend);      
    }
    else {
      return "FAIL";
    }
    
    return "SUCCESS";
  }
  
  @GetMapping("test")
  public String testResult() {
    BbtiResDto result;
    Integer total, dodo, inssa, agyo, sunding, error;
    List<Integer> answers = new ArrayList<Integer>();
    
    total = 0;
    dodo = 0;
    inssa = 0;
    agyo = 0;
    sunding = 0;
    error = 0;
    for(int a1 = 0; a1 <= 1; a1++) {
      for(int a2 = 0; a2 <= 1; a2++) {
        for(int a3 = 0; a3 <= 1; a3++) {
          for(int a4 = 0; a4 <= 1; a4++) {
            for(int a5 = 0; a5 <= 1; a5++) {
              for(int a6 = 0; a6 <= 1; a6++) {
                for(int a7 = 0; a7 <= 1; a7++) {
                  for(int a8 = 0; a8 <= 1; a8++) {
                    for(int a9 = 0; a9 <= 1; a9++) {
                      for(int a10 = 0; a10 <= 1; a10++) {
                        try {
                          answers.add(a1);
                          answers.add(a2);
                          answers.add(a3);
                          answers.add(a4);
                          answers.add(a5);
                          answers.add(a6);
                          answers.add(a7);
                          answers.add(a8);
                          answers.add(a9);
                          answers.add(a10);
                          result = getBbti(answers.toString().replace("[", "").replace("]", "").replace(" ", ""), null);
                          switch(result.getBbti()) {
                            case "DODO":
                              dodo++;
                              break;
                            case "INSSA":
                              inssa++;
                              break;
                            case "AGYO":
                              agyo++;
                              break;
                            case "SUNDING":
                              sunding++;
                              break;
                          }
                        } catch (Exception e) {
                          result = new BbtiResDto();
                          result.setBbti("ERROR");
                          error++;
                        }
                        total++;
                        System.out.println(answers.toString() + " - " + result.getBbti());
                        answers.clear();
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    System.out.println("TOTAL: " + total);
    System.out.println("DODO: " + dodo);
    System.out.println("INSSA: " + inssa);
    System.out.println("AGYO: " + agyo);
    System.out.println("SUNDING: " + sunding);
    System.out.println("ERROR: " + error);
    return "SUCCESS";
  }
  
  @ExceptionHandler(Exception.class)
  public void exceptionHandeler(Exception e) {
	  SlackSendDto slackSend = new SlackSendDto();
	  String errMsg = "";
	  for(StackTraceElement ste : e.getStackTrace()) {
		errMsg += ste.toString() + "\n";
	  }
	  slackSend.setText(errMsg);
	  slackClient.sendSlackMsgToError(slackSend);
  }
}