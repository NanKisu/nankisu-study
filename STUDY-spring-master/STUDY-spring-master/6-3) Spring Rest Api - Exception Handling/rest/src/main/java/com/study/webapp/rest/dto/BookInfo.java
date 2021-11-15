package com.study.webapp.rest.dto;

import java.io.Serializable;
import java.time.LocalDate;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookInfo implements Serializable{
  private String bookId; 
  @NotEmpty
  private String name;
  @NotNull
  private LocalDate publishedDate;
}
