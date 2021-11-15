package com.study.webapp.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = {"/study2"})
public class StudyController2 {
  @GetMapping(path = {"/pathvariable", "/pathvariable/{var}"})
  public String pathVariable(@PathVariable(name = "var", required = false) String var, Model model) {
    model.addAttribute("message", var);
    return "home";
  }
  
  @GetMapping(path = {"/matrixVariable", "/matrixVariable/{var1}", "/matrixVariable/{var1}/{var2}"})
  public String matrixVariable(@PathVariable(value = "var1", required = false) String var1, 
      @MatrixVariable(pathVar = "var1", required = false) Map<String, String> var1_matrix,
      @PathVariable(value = "var2", required = false) String var2,
      @MatrixVariable(pathVar = "var2", required = false) Map<String, String>  var2_matrix) {
    System.out.println(var1);
    System.out.println(var1_matrix);
    System.out.println(var2);
    System.out.println(var2_matrix);
    return "home";
  }
  
  @GetMapping(path = {"/requestparam"})
  public String requsetParam(@RequestParam(name = "param", required = false) String param, Model model) {
    model.addAttribute("message", param);
    return "home";
  }
  
  @GetMapping(path = {"/requestHeader"})
  public String requestHeader(@RequestHeader Map<String,String> header,
      @RequestHeader(name = "user-agent") String userAgent,
      Model model) {
    System.out.println(header);
    model.addAttribute("message", userAgent);
    return "home";
  }
  
  @PostMapping(path = {"/requestbody"})
  public String requestBody(@RequestBody(required = false) String body, Model model) {
    model.addAttribute("message", body);
    return "home";
  }
  
  @GetMapping(path = {"/cookievalue"})
  public String cookieValue(@CookieValue(name = "JSESSIONID", required = false) String jsessionId, Model model) {    
    model.addAttribute("message", jsessionId);
    return "home";
  }
  
  @GetMapping(path = {"/modelattribute"})
  public String modelAttribute(@ModelAttribute(name = "message2") String message2) {
    System.out.println(message2);
    message2 = "modelAttribute";
    System.out.println(message2);
    return "home";
  }
  
  @GetMapping(path = {"/value"})
  public String value(@Value(value = "${message}") String message, Model model) {
    model.addAttribute("message", message);
    return "home";
  }
  
}

