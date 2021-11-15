package com.study.spring.springsecurity.vo;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUser implements UserDetails  {

  private String password;
  private String username;
  
  private static List<GrantedAuthority> getAuthoritiy(String username){
    if("admin".equals(username)) {
      return AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
    }
    return AuthorityUtils.createAuthorityList("ROLE_USER");
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO Auto-generated method stub
    return getAuthoritiy(username);
  }

  @Override
  public String getPassword() {
    // TODO Auto-generated method stub
    return password;
  }

  @Override
  public String getUsername() {
    // TODO Auto-generated method stub
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isEnabled() {
    // TODO Auto-generated method stub
    return true;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public String toString() {
    return "MyUser [password=" + password + ", username=" + username + ", authorities="
        + getAuthorities() + "]";
  }
}
