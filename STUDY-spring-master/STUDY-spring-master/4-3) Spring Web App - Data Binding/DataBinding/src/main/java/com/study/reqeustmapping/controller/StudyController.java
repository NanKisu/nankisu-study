package com.study.reqeustmapping.controller;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/study1")
public class StudyController {
  @InitBinder
  public void stringBinder(DataBinder dataBinder) {
    DateFormatter dateFormatter = new DateFormatter("yyyyMMdd");
    dataBinder.addCustomFormatter(dateFormatter, Date.class);
  }
  
  @GetMapping(path = "/initbinder/{date}")
  public String initBinder(@PathVariable(name = "date") Date date, Model model) {
    model.addAttribute("message", date);
    return "home";
  }
  
  @GetMapping(path = "/datetimeformat")
  public String datetimeformat(@DateTimeFormat(pattern = "yyyyMMdd") @RequestParam(name = "text") Date date, Model model) {
    model.addAttribute("message", date);
    return "home";
  }
  
  @GetMapping(path = "/numberformat")
  public String numberformat(@NumberFormat(pattern = "#.#") @RequestParam(name = "text") Double number, Model model) {
    model.addAttribute("message", number);
    return "home";
  }
}
