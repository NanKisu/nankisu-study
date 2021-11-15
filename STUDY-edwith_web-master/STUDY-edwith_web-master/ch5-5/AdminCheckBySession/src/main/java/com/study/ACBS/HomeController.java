package com.study.ACBS;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

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
	public String home() {
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpSession session) {
		Boolean isAdmin = (Boolean)session.getAttribute("isAdmin");
		
		if(Objects.isNull(isAdmin)) {
			isAdmin = false;
			session.setAttribute("isAdmin", isAdmin);
		}
		
		if(isAdmin) {
			return "redirect:/admin_page";
		}
		
		return "login";
	}
	
	@RequestMapping(value = "/login_submit", method = RequestMethod.POST)
	public String loginSubmit(HttpSession session, @RequestParam(name="password", required = false, defaultValue = "") String password) {
		if("password".equals(password)) {
			session.setAttribute("isAdmin", true);
		}
		else {
			session.setAttribute("isAdmin", false);			
		}
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/admin_page", method = RequestMethod.GET)
	public String adminPage(HttpSession session) {
		Boolean isAdmin = (Boolean)session.getAttribute("isAdmin");
		
		if(Objects.isNull(isAdmin)) {
			isAdmin = false;
			session.setAttribute("isAdmin", isAdmin);
		}
		
		if(!isAdmin) {
			return "redirect:/login";
		}
		
		return "admin_page";
	}
}
