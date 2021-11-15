package com.study.www.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.www.springmvc.dto.User;

@Controller
public class UserController {
	@GetMapping(path="/userform")
	public String userform() {
		return "userform";
	}
	
	@PostMapping(path="regist")
	public String regist(@ModelAttribute User user) {
		System.out.println(user);
		return "regist";
	}
}
