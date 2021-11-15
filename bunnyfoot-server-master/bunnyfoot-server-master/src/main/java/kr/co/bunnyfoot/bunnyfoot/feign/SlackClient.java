package kr.co.bunnyfoot.bunnyfoot.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import kr.co.bunnyfoot.bunnyfoot.dto.SlackSendDto;

@FeignClient(name="feign2", url="https://hooks.slack.com/services")
public interface SlackClient {

    @PostMapping(path = {"${slack.welcome}"})
    public void sendSlackMsgToWelcome(@RequestBody SlackSendDto slackSend);
    
    @PostMapping(path = {"${slack.error}"})
    public void sendSlackMsgToError(@RequestBody SlackSendDto slackSend);
}