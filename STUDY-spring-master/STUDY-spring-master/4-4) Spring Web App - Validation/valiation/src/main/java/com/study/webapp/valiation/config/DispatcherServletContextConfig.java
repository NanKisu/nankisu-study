package com.study.webapp.valiation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@PropertySource(value = {"classpath:application-message.properties"})
@EnableWebMvc
@ComponentScan(basePackages = {"com.study.webapp.valiation.controller", "com.study.webapp.valiation.validator"})
public class DispatcherServletContextConfig extends WebMvcConfigurationSupport{
  
  @Bean
  public InternalResourceViewResolver internalResourceViewResolver() {
    return new InternalResourceViewResolver("/", ".jsp");
  }
}
