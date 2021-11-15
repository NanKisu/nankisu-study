package com.study.webapp.valiation.dto;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import lombok.Data;

@Data
public class AssertTrueFalseInDto {
  @AssertTrue
  private boolean flag1;
  
  @AssertFalse
  private boolean flag2;
}
