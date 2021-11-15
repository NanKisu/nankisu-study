package com.springwebmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.springwebmvc.dto.UserInfo;
import com.springwebmvc.dto.UserInfoSessionScope;

@Controller
@RequestMapping(path = {"/session"})
@SessionAttributes(names = {"name"}, types = {UserInfo.class})
public class SessionController {
  @Autowired
  private UserInfoSessionScope userInfoSessionScope;
  
  @ModelAttribute(name = "userInfo")
  public UserInfo userInfo() {
    return new UserInfo();
  }
  
  @GetMapping(path = {"/init"})
  public String sessionInit(UserInfo userInfo, Model model) {
    userInfo.setName("nankisu");
    userInfo.setAge("27");
    userInfoSessionScope.setName("nankisu");
    userInfoSessionScope.setAge("27");
    model.addAttribute("userInfoSessionScope", userInfoSessionScope);
    model.addAttribute("name", "nankisu");
    model.addAttribute("age", "27");
    return "session";
  }
  
  @GetMapping(path = {"/name"})
  public String sessionName(Model model) {
    model.addAttribute("userInfoSessionScope", userInfoSessionScope);
    return "session";
  }
  
  @GetMapping(path = {"/userinfo"})
  public String sessionUserInfo(Model model) {
    model.addAttribute("userInfoSessionScope", userInfoSessionScope);
    return "session";
  }
}
