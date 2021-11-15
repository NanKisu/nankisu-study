package com.study.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = {"/study3"})
public class StudyController3 {
  
  @GetMapping(path = {"/string"})
  public String string() {
    return "home";
  }
  
  @GetMapping(path = {"/model"})
  public ModelMap model() {
    ModelMap model = new ModelMap();
    model.addAttribute("message2", "model");
    return model;
  }
  
  @GetMapping(path = {"/modelandview"})
  public ModelAndView modelAndView() {
    ModelAndView modelAndView = new ModelAndView();
   
    modelAndView.setViewName("home");
    modelAndView.addObject("message2", "modelandview");
    
    return modelAndView;
  }
  
  
  
}

