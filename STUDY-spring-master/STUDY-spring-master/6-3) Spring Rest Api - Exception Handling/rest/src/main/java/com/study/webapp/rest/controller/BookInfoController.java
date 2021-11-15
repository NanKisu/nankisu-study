package com.study.webapp.rest.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import com.study.webapp.rest.dao.BookInfoDao;
import com.study.webapp.rest.dto.BookInfo;
import com.study.webapp.rest.dto.SearchBookInfoCondition;
import com.study.webapp.rest.exception.NoDataException;

@RestController
@RequestMapping(path = {"/bookinfo"})
public class BookInfoController {
  @Autowired
  private BookInfoDao bookInfoDao;
  
  @GetMapping(path = {"/{bookId}"})
  public List<BookInfo> getBookInfo(@PathVariable Integer bookId) {
    List<BookInfo> res = bookInfoDao.readBookInfoById(bookId);
    if(ObjectUtils.isEmpty(res)) {
     throw new NoDataException(); 
    }
    return res;
  }
  
  @GetMapping
  public List<BookInfo> getBookInfoByCondition(SearchBookInfoCondition condition) {
    List<BookInfo> res = bookInfoDao.readBookInfoByCondition(condition);
    if(ObjectUtils.isEmpty(res)) {
     throw new NoDataException(); 
    }
    return res;
  }
  
//  @PostMapping
//  public ResponseEntity<Void> createBookInfo(@RequestBody BookInfo bookInfo, UriComponentsBuilder uriBuilder) {
//    Integer bookId = bookInfoDao.createBookInfo(bookInfo);
//    URI resourceUri = uriBuilder.path("/bookinfo/{bookId}").buildAndExpand(bookId).encode().toUri();
//    return ResponseEntity.created(resourceUri).build();
//  }
  
  @PostMapping
  public ResponseEntity<Void> createBookInfo(@RequestBody @Valid BookInfo bookInfo, UriComponentsBuilder uriBuilder) {
    Integer bookId = bookInfoDao.createBookInfo(bookInfo);
    URI resourceUri = MvcUriComponentsBuilder.relativeTo(uriBuilder).withMethodCall(MvcUriComponentsBuilder.on(BookInfoController.class).getBookInfo(bookId)).build().encode().toUri();
    return ResponseEntity.created(resourceUri).build();
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

