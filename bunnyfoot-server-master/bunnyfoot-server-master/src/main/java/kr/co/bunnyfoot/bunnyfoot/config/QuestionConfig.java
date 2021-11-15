package kr.co.bunnyfoot.bunnyfoot.config;

import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import kr.co.bunnyfoot.bunnyfoot.dto.QuestionDto;
import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "question")
public class QuestionConfig {
  private Map<String, QuestionDto> question;
}
