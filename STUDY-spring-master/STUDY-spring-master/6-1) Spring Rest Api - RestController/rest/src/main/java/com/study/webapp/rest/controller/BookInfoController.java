package com.study.webapp.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.study.webapp.rest.dao.BookInfoDao;
import com.study.webapp.rest.dto.BookInfo;

@RestController
@RequestMapping(path = {"/bookinfo"})
public class BookInfoController {
  @Autowired
  private BookInfoDao bookInfoDao;
  
  @GetMapping(path = {"/{bookId}"})
  public List<BookInfo> getBookInfo(@PathVariable Integer bookId) {
    return bookInfoDao.readBookInfoById(bookId);
  }
  
  @PostMapping
  public Integer createBookInfo(@RequestBody BookInfo bookInfo) {
    return bookInfoDao.createBookInfo(bookInfo);
  }
  
  @PutMapping
  public Integer updateBookInfo(@RequestBody BookInfo bookInfo) {
    return bookInfoDao.updateBookInfo(bookInfo);
  }
  
  @DeleteMapping(path = {"/{bookId}"})
  public Integer deleteBookInfo(@PathVariable Integer bookId) {
    return bookInfoDao.deleteBookInfoById(bookId);
  }
}

