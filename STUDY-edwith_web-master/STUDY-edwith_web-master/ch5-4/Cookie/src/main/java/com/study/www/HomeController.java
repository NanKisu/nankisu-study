package com.study.www;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@CookieValue(name="visit_count", required = false, defaultValue = "0") Integer visit_count, HttpServletResponse response, ModelMap model) {
		visit_count++;
		
		Cookie cookie = new Cookie("visit_count", visit_count.toString());
		cookie.setMaxAge(-1);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		model.addAttribute("visit_count", visit_count);
		
		return "home";
	}
	
}
