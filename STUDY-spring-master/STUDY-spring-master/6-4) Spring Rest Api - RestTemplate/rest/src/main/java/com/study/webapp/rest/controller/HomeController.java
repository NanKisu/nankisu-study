package com.study.webapp.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@CrossOrigin(origins = {"*"})
@Controller
@RequestMapping(path = {"/"})
public class HomeController {
  @GetMapping
  public String home() {
    return "home";
  }
  
  @GetMapping(value = {"/throwex"})
  public String throwEx() throws Exception {
    throw new Exception();
  }
  
  @ExceptionHandler(value = {Exception.class})
  public String handleEx(Exception ex, Model model) {
    model.addAttribute("ex", ex);
    return "error";
  }
}
