package com.study.webapp.exception.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {
  
  @ExceptionHandler(Throwable.class)
  public String errorPage(Exception e, Model model) {
    System.out.println("message:" + e.getMessage());
    model.addAttribute("message", e.getMessage());
    return "error";
  }
  
}
