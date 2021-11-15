package com.study.webapp.valiation.dto;

import java.util.List;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class MyValidatorInDto {
  @Size(min = 3, max = 5, message = "길이는 3이상 5이하여야 합니다.")
  private List<String> var;
}
