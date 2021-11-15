package com.study.webapp.valiation.dto;

import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PatternInDto {
  @Pattern(regexp = "[0-9a-zA-Z]+-[0-9a-zA-Z]+")
  private String var;
}
