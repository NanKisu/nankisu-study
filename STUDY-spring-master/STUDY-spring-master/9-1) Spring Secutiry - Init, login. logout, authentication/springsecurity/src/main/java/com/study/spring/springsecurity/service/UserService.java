package com.study.spring.springsecurity.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.study.spring.springsecurity.dao.MyUserDao;
import com.study.spring.springsecurity.vo.MyUser;

@Service
public class UserService implements UserDetailsService{

  @Autowired
  private MyUserDao myUserDAO;
  
  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // TODO Auto-generated method stub
    System.out.println("username: " + username);
    List<MyUser> myUsers = myUserDAO.selectByUsername(username);
    System.out.println(myUsers);
    return myUsers.get(0);
  }


}
