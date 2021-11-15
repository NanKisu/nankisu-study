package com.example.openbanking.openbanking.dto;

import lombok.Data;

@Data
public class TokenResponseDto {
  private String access_token;
  private String token_type;
  private String refresh_token;
  private String expires_in;
  private String scope;
  private String user_seq_no;  
}
