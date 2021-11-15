package kr.co.bunnyfoot.bunnyfoot.dto;

import lombok.Data;

@Data
public class MySlackSendDto {
  private String channel;
  private String msg;
}
