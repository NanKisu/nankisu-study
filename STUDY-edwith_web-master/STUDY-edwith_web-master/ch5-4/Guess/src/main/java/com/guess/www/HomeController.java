package com.guess.www;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session, ModelMap model) {
		Integer count = (Integer)session.getAttribute("count");
		Integer target = (Integer)session.getAttribute("target");
		
		if(count == null) {
			count = 0;
			session.setAttribute("count", count);
		}
		if(target == null) {
			target = (int)(Math.random() * 100 + 1);
			session.setAttribute("target", target);
		}
		
		model.addAttribute("message", "START");
		
		return "guess";
	}
	
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String submit(HttpSession session, 
			@RequestParam(name="number", required = true, defaultValue = "0") Integer number,
			ModelMap model) {
		Integer count = (Integer)session.getAttribute("count");
		Integer target = (Integer)session.getAttribute("target");
		count++;
		session.setAttribute("count", count);
		
		if(target > number) {
			model.addAttribute("message", "UP");
		}
		else if(target < number) {
			model.addAttribute("message", "DOWN");
		}
		else {
			model.addAttribute("message", count.toString() + " TRY");	
			session.invalidate();
		}
		
		return "guess";
	}
	
}
