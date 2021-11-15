package com.study.webapp.valiation.dto;

import com.study.webapp.valiation.annotation.AlphaNumeric;
import lombok.Data;

@Data
public class AlphaNumericInDto {
  @AlphaNumeric
  private String str;
}
