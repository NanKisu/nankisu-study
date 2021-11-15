package com.study.spring.springsecurity.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import com.study.spring.springsecurity.vo.MyUser;

@Repository
public class MyUserDao {

  private SimpleJdbcInsert jdbcInsert;
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  public MyUserDao(DataSource dataSource){
    jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("myuser").usingColumns("username", "password");
    jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
  }
  
  public List<MyUser> selectByUsername(String username) {
    Map<String, Object> params = new HashMap<String,Object>();
    params.put("username", username);
    System.out.println(params);
    return jdbcTemplate.query("SELECT * FROM myuser WHERE username = :username", params, BeanPropertyRowMapper.newInstance(MyUser.class));
  }
  
}
