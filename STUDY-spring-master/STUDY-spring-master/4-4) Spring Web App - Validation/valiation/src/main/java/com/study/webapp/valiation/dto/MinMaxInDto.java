package com.study.webapp.valiation.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Data;

@Data
public class MinMaxInDto {
  @Min(value = 1)
  @Max(value = 10)
  private Integer var;
}
