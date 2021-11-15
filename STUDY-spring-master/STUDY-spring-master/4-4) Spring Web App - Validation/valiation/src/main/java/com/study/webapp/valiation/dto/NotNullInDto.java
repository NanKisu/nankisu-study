package com.study.webapp.valiation.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NotNullInDto {
  @NotNull
  private String var;
}
