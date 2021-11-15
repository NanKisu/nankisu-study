package com.study.www.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlusController {
	@GetMapping(path="/plusform")
	public String plusform() {
		return "plusform";
	}
	
	@PostMapping(path="/plus")
	public String plus(int value1, int value2, ModelMap modelMap) {
		modelMap.addAttribute("value1", value1);
		modelMap.addAttribute("value2", value2);
		modelMap.addAttribute("result", value1 + value2);
		return "plus";
	}
}
