package com.study.reqeustmapping.controller;

import java.util.Date;
import java.util.Formatter;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/study1")
public class StudyController {
  @InitBinder
  public void stringBinder(DataBinder dataBinder) {
    DateFormatter dateFormatter = new DateFormatter("yyyyMMdd");
    dataBinder.addCustomFormatter(dateFormatter, Date.class);
  }
  
  @GetMapping(path = "/path")
  public String path(Model model) {
    model.addAttribute("message", "path message");
    return "home";
  }
  
  @GetMapping(path = "/path2/{pattern:[0-9]}")
  public String path2(@PathVariable(name = "pattern") String pattern, Model model) {
    model.addAttribute("message", "pattern: " + pattern);
    return "home";
  }
  
  @GetMapping(path = "/**/path3")
  public String path3(Model model) {
    model.addAttribute("message", "path3");
    return "home";
  }
  
  @GetMapping(path = "/params", params = "one")
  public String paramsOne(Model model) {
    model.addAttribute("message", "params one");
    return "home";
  }
  
  @GetMapping(path = "/params", params = "two")
  public String paramsTwo(Model model) {
    model.addAttribute("message", "params two");
    return "home";
  }
  
  @GetMapping(path = "/params", params = "three=3")
  public String paramsThree(Model model) {
    model.addAttribute("message", "params three");
    return "home";
  }
  
  @GetMapping(path = "/headers", headers = "Cookie")
  public String headers(Model model) {
    model.addAttribute("message", "headers");
    return "home";
  }
  
  @GetMapping(path = "/consumes", consumes = "application/json")
  public String consules(Model model) {
    model.addAttribute("message", "consumes");
    return "home";
  }
  
  @GetMapping(path = "/produces", produces = "text/html")
  public String produces(Model model) {
    model.addAttribute("message", "produces");
    return "home";
  }
  
  
  @GetMapping(path = "/initbinder/{date}")
  public String initBinder(@PathVariable(name = "date") Date date, Model model) {
    model.addAttribute("message", date);
    return "home";
  }
}
