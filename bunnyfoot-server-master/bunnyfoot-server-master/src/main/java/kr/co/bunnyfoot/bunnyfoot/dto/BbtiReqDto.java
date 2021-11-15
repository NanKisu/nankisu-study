package kr.co.bunnyfoot.bunnyfoot.dto;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import lombok.Data;

@Data
public class BbtiReqDto {
  
  private List<Integer> answers;
  private MultipartFile image;
}
