package com.study.spring.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path= {"/"})
public class HomeController {
	@GetMapping
	public String home(HttpServletRequest request) {
		System.out.println(request.getAttribute("ipInfo"));
		return "home";
	}
}
