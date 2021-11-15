package com.study.spring.springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.study.spring.springjpa.model.MyUser;
import com.study.spring.springjpa.repository.MyUserRepository;
import com.study.spring.springjpa.service.MyUserService;

@Controller
@RequestMapping("/")
public class HomeController {
  @Autowired
  private MyUserService myUserService;
  
  @GetMapping
  public String home() {
    System.out.println("Welcome!");
    MyUser myUser = new MyUser();
    myUser.setAge(20);
    myUser.setName("kisued");
    myUserService.createMyUser(myUser);
    System.out.println(myUserService.findByAge(20));
    System.out.println(myUserService.findByName("kisued"));
    return "home";
  }
  
}
