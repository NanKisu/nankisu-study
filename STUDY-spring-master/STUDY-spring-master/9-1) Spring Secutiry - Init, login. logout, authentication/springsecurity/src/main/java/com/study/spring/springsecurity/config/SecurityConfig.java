
package com.study.spring.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.study.spring.springsecurity.listener.AuthenticationEventListener;
import com.study.spring.springsecurity.service.UserService;

@Configuration
@ComponentScan(basePackages = {"com.study.spring.springsecurity"})
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserService userService;

  @Autowired
  private void configureAuthenticationManeger(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService);
    auth.authenticationEventPublisher(defaultAuthenticationEventPublisher());
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public DefaultAuthenticationEventPublisher defaultAuthenticationEventPublisher() {
    return new DefaultAuthenticationEventPublisher();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    // TODO Auto-generated method stub
    web.ignoring().antMatchers("/resources");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // TODO Auto-generated method stub
    http.formLogin().loginPage("/login").loginProcessingUrl("/authenticate")
        .usernameParameter("username").passwordParameter("password").permitAll();
    http.logout().logoutUrl("/logout").permitAll();
    http.authorizeRequests().antMatchers("/").hasRole("USER").antMatchers("/home").hasRole("USER")
        .antMatchers("/admin").hasRole("ADMIN").anyRequest().authenticated();
    http.exceptionHandling().accessDeniedPage("/home");
  }



}
