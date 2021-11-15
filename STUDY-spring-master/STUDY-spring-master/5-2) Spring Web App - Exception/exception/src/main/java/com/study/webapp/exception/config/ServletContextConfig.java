package com.study.webapp.exception.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.study.webapp.exception.controller"})
public class ServletContextConfig extends WebMvcConfigurationSupport{
  @Bean
  public InternalResourceViewResolver internalResourceViewResolver() {
    return new InternalResourceViewResolver("/", ".jsp");
  }
}
