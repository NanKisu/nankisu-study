package com.study.webapp.valiation.dto;

import java.util.Date;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
public class PastFutureInDto {
  @Past
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date past;
  @Future
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date future;
}
