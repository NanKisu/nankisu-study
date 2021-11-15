package com.example.openbanking.openbanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.openbanking.openbanking.dto.AccountListDto;
import com.example.openbanking.openbanking.dto.TokenRequestDto;
import com.example.openbanking.openbanking.dto.TokenResponseDto;
import com.example.openbanking.openbanking.feign.OpenBankingFeign;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class OpenBankingController {
  @Autowired
  private OpenBankingFeign openBankingFeign;
  
  @Value("${client_secret}")
  private String client_secret;
  
  @PostMapping("/requestToken")
  public TokenResponseDto requestToken(@RequestBody TokenRequestDto tokenReqeust) {
    tokenReqeust.setClient_secret(client_secret);
    TokenResponseDto tokenResponse = openBankingFeign.requestToken(tokenReqeust.getCode(), tokenReqeust.getClient_id(), tokenReqeust.getClient_secret(), tokenReqeust.getRedirect_uri(), tokenReqeust.getGrant_type());
    return tokenResponse;
  }
  
  @GetMapping("/account/list")
  public AccountListDto getAccountList(String access_token, String user_seq_no, String include_cancel_yn, String sort_order) {
    return openBankingFeign.requestAccountList("Bearer " + access_token, user_seq_no, include_cancel_yn, sort_order);
  }
}
