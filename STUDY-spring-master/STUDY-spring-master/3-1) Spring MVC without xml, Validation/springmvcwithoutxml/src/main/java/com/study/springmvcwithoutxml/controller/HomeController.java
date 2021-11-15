package com.study.springmvcwithoutxml.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.study.springmvcwithoutxml.vo.InputText;

@Controller
@RequestMapping(value = "/")
public class HomeController{
  @RequestMapping(value = {"", "home"}, method = RequestMethod.GET)
  public String home() {
    return "home";
  }
  
  @RequestMapping(value = "input", method = RequestMethod.GET)
  public String input() {
    return "input";
  }
  
  @RequestMapping(value = "output", method = RequestMethod.POST)
  public String output(@Valid InputText text, ModelMap model, BindingResult result) {
    if(result.hasErrors()) {
      return "input";
    }
    model.addAttribute("text", text.getText());
    return "output";
  }
}
