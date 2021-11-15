package com.study.spring.springsecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.study.spring.springsecurity.vo.MyUser;

@Controller
@RequestMapping(path = {"/"})
public class HomeController {
  @GetMapping(path = {"", "home"})
  public String home(@AuthenticationPrincipal MyUser curUser) {
    System.out.println("curUser: " + curUser.getUsername() + ", " + curUser.getPassword() + ", "  + curUser.getAuthorities());
    return "home";
  }
  
  @GetMapping(path = {"admin"})
  public String admin(@AuthenticationPrincipal MyUser curUser) {
    System.out.println("curUser: " + curUser.getUsername() + ", " + curUser.getPassword() + ", "  + curUser.getAuthorities());
    return "admin";
  }
}
