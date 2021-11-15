package com.study.webapp.valiation.dto;

import com.study.webapp.valiation.annotation.IsEqualTwoProperties;
import lombok.Data;

@Data
@IsEqualTwoProperties(property1 = "str1", property2 = "str2")
public class IsEqualInDto {
  private String str1;
  private String str2;
}