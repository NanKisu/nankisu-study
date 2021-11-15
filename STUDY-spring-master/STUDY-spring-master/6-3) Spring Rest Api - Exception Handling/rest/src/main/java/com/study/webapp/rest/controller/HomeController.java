package com.study.webapp.rest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.study.webapp.rest.dto.BookInfo;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping(path = {"/"})
public class HomeController {
  @GetMapping
  public String home() {
    return "home";
  }
}
