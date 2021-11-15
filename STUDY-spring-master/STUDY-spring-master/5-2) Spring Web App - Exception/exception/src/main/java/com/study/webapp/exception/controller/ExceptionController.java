package com.study.webapp.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/throw"})
public class ExceptionController {
  @GetMapping(path = {"/exception"})
  public String exception() throws Exception {
    throw new Exception("MyException");
  }
}
