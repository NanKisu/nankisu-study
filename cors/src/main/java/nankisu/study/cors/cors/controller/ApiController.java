package nankisu.study.cors.cors.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
	@GetMapping("/test")
	public String getTest() {
		return "SUCCESS";
	}
	
	@PutMapping("/test")
	public String putTest() {
		return "SUCCESS";
	}
}
