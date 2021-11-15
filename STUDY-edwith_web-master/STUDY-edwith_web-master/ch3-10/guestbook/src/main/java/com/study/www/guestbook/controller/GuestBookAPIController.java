package com.study.www.guestbook.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.www.guestbook.dto.GuestBook;
import com.study.www.guestbook.service.GuestBookService;
@RestController
@RequestMapping(path="/guestbooks")
public class GuestBookAPIController {
	@Autowired
	GuestBookService guestBookService;
	
	@GetMapping
	public List<GuestBook> getGuestBooks(@RequestParam(name="start", required = false, defaultValue = "0") Integer start){
		return guestBookService.getGuestBooks(start); 
	}
	
	@PostMapping
	public GuestBook postGusetBook(@RequestBody GuestBook guestBook, HttpServletRequest request) {
		GuestBook resultGuestBook = guestBookService.addGuestBook(guestBook, request.getRemoteAddr());
		return resultGuestBook;
	}
	
	@DeleteMapping(path="/{id}")
	public Map<String, String> deleteGuestBook(@PathVariable(name = "id") Long id,HttpServletRequest request){
		Integer result = guestBookService.deleteGuestBook(id, request.getRemoteAddr());
		return Collections.singletonMap("success", result > 0 ? "ture" : "false");
	}
}
