package com.study.webapp.rest.dto;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
public class BookInfo implements Serializable{
  private String bookId; 
  private String name;
  private LocalDate publishedDate;
}
