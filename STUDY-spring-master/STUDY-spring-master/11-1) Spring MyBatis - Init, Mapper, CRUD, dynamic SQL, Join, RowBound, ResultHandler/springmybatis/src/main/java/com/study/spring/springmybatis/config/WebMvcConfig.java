package com.study.spring.springmybatis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan("com.study.spring.springmybatis")
public class WebMvcConfig extends WebMvcConfigurationSupport{
  @Bean
  public InternalResourceViewResolver internalResourceViewResolver() {
    return new InternalResourceViewResolver("/", ".jsp");
  }
}
