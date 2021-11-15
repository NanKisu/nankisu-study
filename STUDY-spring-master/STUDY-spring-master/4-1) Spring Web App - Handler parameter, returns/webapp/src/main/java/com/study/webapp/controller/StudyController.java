package com.study.webapp.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.study.webapp.vo.FormInput;

@Controller
@RequestMapping(path = {"/study"})
public class StudyController {
  
  @GetMapping(path = {"/model"})
  public String model(Model model) {
    model.addAttribute("message", "models message");
    return "home";
  }
  
  @GetMapping(path = {"/redirectattribute"})
  public String redirectattribute(RedirectAttributes redirectAttributes) {
    redirectAttributes.addAttribute("message", "redirectAttributes message");   
    return "redirect:/";
  }
  
  @PostMapping(path = {"/beansandvalidation"})
  public String beansandvalidation(@Valid FormInput formInput, BindingResult bindingResult, Model model) {
    System.out.println("formInput: " + formInput);
    if(bindingResult.hasErrors()) {
      model.addAttribute("message", "bindingResult have a error.");   
      return "home";
    }
    model.addAttribute("message", "bindingResult doesn't have a error.");   
    return "home";
  }
  
  
  
  
}
