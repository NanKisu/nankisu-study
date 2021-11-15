package com.study.webapp.rest.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestOperations;
import com.study.webapp.rest.dto.BookInfo;

@Controller
@RequestMapping(value = {"/rest"})
public class RestController {
  @Autowired
  RestOperations restOperations;
  
  @GetMapping(value = {"/get"})
  public String getRest(String bookId, Model model) {
    BookInfo bookInfo = restOperations.getForObject("http://localhost:8080/rest/bookinfo/{bookId}", BookInfo.class, bookId);
    model.addAttribute("model", bookInfo);
    return "get";
  }
  
  @GetMapping(value = {"/post"})
  public String postRest() {
    return "post";
  }
  
  @PostMapping(value = {"/post"})
  public String postRestAction(String name, String publishedDate, Model model) {
    BookInfo bookInfo = new BookInfo();
    bookInfo.setName( name);
    bookInfo.setPublishedDate(LocalDate.parse(publishedDate));
    model.addAttribute("model", restOperations.postForLocation("http://localhost:8080/rest/bookinfo", bookInfo));
    return "get";
  }
}
