package com.study.webapp.valiation.controller;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.study.webapp.valiation.dto.AlphaNumericInDto;
import com.study.webapp.valiation.dto.AssertTrueFalseInDto;
import com.study.webapp.valiation.dto.IsEqualInDto;
import com.study.webapp.valiation.dto.MinMaxInDto;
import com.study.webapp.valiation.dto.MyValidatorInDto;
import com.study.webapp.valiation.dto.NotNullInDto;
import com.study.webapp.valiation.dto.PastFutureInDto;
import com.study.webapp.valiation.dto.PatternInDto;
import com.study.webapp.valiation.dto.SizeInDto;
import com.study.webapp.valiation.validator.MyValidator;

@RestController
@RequestMapping(path = {"/api/"})
public class ApiController {
  @Autowired
  private MyValidator myValidator;
  
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.addValidators(myValidator);
  }

  @PostMapping(path = {"/notnull"})
  public Map<String, Object> notnull(@Valid @RequestBody NotNullInDto inDto, BindingResult bindingResult) {
    Map<String, Object> res = new HashMap<String, Object>();
    if(bindingResult.hasErrors()) {
      res.put("result", bindingResult.getAllErrors());
      res.put("response", inDto);
    }
    else {      
      res.put("result", "Ok");
      res.put("response", inDto);
    }
    return res;
  }
  
  @PostMapping(path = {"/size"})
  public Map<String, Object> size(@Valid @RequestBody SizeInDto inDto, BindingResult bindingResult) {
    Map<String, Object> res = new HashMap<String, Object>();
    if(bindingResult.hasErrors()) {
      res.put("result", bindingResult.getAllErrors());
      res.put("response", inDto);
    }
    else {      
      res.put("result", "Ok");
      res.put("response", inDto);
    }
    return res;
  }
  
  @PostMapping(path = {"/pattern"})
  public Map<String, Object> pattern(@Valid @RequestBody PatternInDto inDto, BindingResult bindingResult) {
    Map<String, Object> res = new HashMap<String, Object>();
    if(bindingResult.hasErrors()) {
      res.put("result", bindingResult.getAllErrors());
      res.put("response", inDto);
    }
    else {      
      res.put("result", "Ok");
      res.put("response", inDto);
    }
    return res;
  }
  
  @PostMapping(path = {"/minmax"})
  public Map<String, Object> minMax(@Valid @RequestBody MinMaxInDto inDto, BindingResult bindingResult) {
    Map<String, Object> res = new HashMap<String, Object>();
    if(bindingResult.hasErrors()) {
      res.put("result", bindingResult.getAllErrors());
      res.put("response", inDto);
    }
    else {      
      res.put("result", "Ok");
      res.put("response", inDto);
    }
    return res;
  }
  
  @PostMapping(path = {"/pastfuture"})
  public Map<String, Object> fastFuture(@Valid @RequestBody PastFutureInDto inDto, BindingResult bindingResult) {
    Map<String, Object> res = new HashMap<String, Object>();
    if(bindingResult.hasErrors()) {
      res.put("result", bindingResult.getAllErrors());
      res.put("response", inDto);
    }
    else {      
      res.put("result", "Ok");
      res.put("response", inDto);
    }
    return res;
  }
  
  @PostMapping(path = {"/asserttruefalse"})
  public Map<String, Object> assertTrueFalse(@Valid @RequestBody AssertTrueFalseInDto inDto, BindingResult bindingResult) {
    Map<String, Object> res = new HashMap<String, Object>();
    if(bindingResult.hasErrors()) {
      res.put("result", bindingResult.getAllErrors());
      res.put("response", inDto);
    }
    else {      
      res.put("result", "Ok");
      System.out.println(inDto);
      res.put("response", inDto);
    }
    return res;
  }
  
  @PostMapping(path = {"/alphanumeric"})
  public Map<String, Object> AlphaNumeric(@Valid @RequestBody AlphaNumericInDto inDto, BindingResult bindingResult) {
    Map<String, Object> res = new HashMap<String, Object>();
    if(bindingResult.hasErrors()) {
      res.put("result", bindingResult.getAllErrors());
      res.put("response", inDto);
    }
    else {      
      res.put("result", "Ok");
      System.out.println(inDto);
      res.put("response", inDto);
    }
    return res;
  }
  
  @PostMapping(path = {"/isequal"})
  public Map<String, Object> AlphaNumeric(@Valid @RequestBody IsEqualInDto inDto, BindingResult bindingResult) {
    Map<String, Object> res = new HashMap<String, Object>();
    if(bindingResult.hasErrors()) {
      res.put("result", bindingResult.getAllErrors());
      res.put("response", inDto);
    }
    else {      
      res.put("result", "Ok");
      System.out.println(inDto);
      res.put("response", inDto);
    }
    return res;
  }
  
  @PostMapping(path = {"/myvalidator"})
  public Map<String, Object> myValidator(@Valid @RequestBody MyValidatorInDto inDto, BindingResult bindingResult) {
    Map<String, Object> res = new HashMap<String, Object>();
    if(bindingResult.hasErrors()) {
      res.put("result", bindingResult.getAllErrors());
      res.put("response", inDto);
    }
    else {      
      res.put("result", "Ok");
      System.out.println(inDto);
      res.put("response", inDto);
    }
    return res;
  }
}
