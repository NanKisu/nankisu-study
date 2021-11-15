package com.springwebmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(path = {"/file"})
public class FileController {
  @GetMapping
  public String file() {
    return "file";
  }
  
  @PostMapping
  public String getFile(MultipartFile file) {
    System.out.println(file.getName());
    System.out.println(file.getContentType());
    System.out.println(file.getOriginalFilename());
    System.out.println(file.getSize());
    return "file";
  }
}
