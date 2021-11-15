package com.study.spring.springmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.study.spring.springmybatis.mapper.MyUserMapper;
import com.study.spring.springmybatis.model.MyUser;
import com.study.spring.springmybatis.model.MyUserCriteria;

@Controller
@RequestMapping("/")
public class HomeController {
  @Autowired
  private MyUserMapper myUserMapper;

  @GetMapping
  public String home() {    
    System.out.println(myUserMapper.findAll());
    
//    MyUser myUser =new MyUser();
//    myUser.setId(1);
//    myUser.setName("LeeKisu");
//    myUser.setAge(20);
//    myUserMapper.update(myUser);
//    
//    System.out.println(myUserMapper.findAll());
//    
//    myUserMapper.delete(1);
//    
//    System.out.println(myUserMapper.findAll());
//    
//    myUserMapper.create(myUser);
//    
//    System.out.println(myUserMapper.findAll());
//
//    MyUserCriteria myUserCriteria = new MyUserCriteria();
//    myUserCriteria.setAge(20);
//    myUserCriteria.setIsLike(false);
//    System.out.println(myUserMapper.findByCriteria(myUserCriteria));
//
//    myUserCriteria.setName("nankisy");
//    myUserCriteria.setIsLike(true);
//    System.out.println(myUserMapper.findByCriteria(myUserCriteria));

    System.out.println(myUserMapper.findJoinById(1));

    return "home";
  }

}
