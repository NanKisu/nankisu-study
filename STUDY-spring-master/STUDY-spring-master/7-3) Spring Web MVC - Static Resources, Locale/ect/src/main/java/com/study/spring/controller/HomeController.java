package com.study.spring.controller;

import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/"})
public class HomeController {
  @GetMapping
  public String home(Model model, Locale locale) {
    model.addAttribute("locale", locale);
    return "home";
  }
}
