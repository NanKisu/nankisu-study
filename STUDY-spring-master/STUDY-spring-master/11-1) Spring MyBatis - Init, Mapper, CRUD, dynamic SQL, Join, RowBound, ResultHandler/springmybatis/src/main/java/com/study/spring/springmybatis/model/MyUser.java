package com.study.spring.springmybatis.model;

import lombok.Data;

@Data
public class MyUser {
  private Integer id;
  private String name;
  private Integer age;
  private UserGender gender;
}
