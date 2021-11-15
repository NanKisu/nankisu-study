package com.study.www.guestbook.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.study.www.guestbook.dao.GuestBookDao;
import com.study.www.guestbook.dao.LogDao;
import com.study.www.guestbook.dto.GuestBook;
import com.study.www.guestbook.dto.Log;
import com.study.www.guestbook.service.GuestBookService;

@Controller
public class GuestBookController {
	@Autowired
	GuestBookService guestBookService;
	
	@GetMapping(path="/")
	public RedirectView index() {
		return new RedirectView("list");
	}
	
	@GetMapping(path="/list")
	public String list(@RequestParam(name="start", required=true, defaultValue="0") Integer start, ModelMap modelMap) {
		List<GuestBook> guestBooks = guestBookService.getGuestBooks(start);
		modelMap.addAttribute("guestBooks", guestBooks);
		modelMap.addAttribute("count", (guestBookService.getCount() + 4) / 5);
		return "list";
	}
	
	@PostMapping(path="/write")
	public RedirectView write(@ModelAttribute GuestBook guestBook, HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		guestBookService.addGuestBook(guestBook, ip);
		return new RedirectView("list");
	}
}
