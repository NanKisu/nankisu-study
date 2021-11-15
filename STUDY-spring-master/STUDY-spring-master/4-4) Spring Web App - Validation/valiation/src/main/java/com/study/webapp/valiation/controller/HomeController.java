package com.study.webapp.valiation.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/"})
public class HomeController {

  @GetMapping
  public Map<String, Object> home() {
    Map<String, Object> res = new HashMap<String, Object>();
    res.put("response", "home");
    return res;
  }
}
