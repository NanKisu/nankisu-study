package com.springwebmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@EnableAsync
@ComponentScan(basePackages = {"com.springwebmvc.controller", "com.springwebmvc.dto"})
public class DispatcherServletContextConfig extends WebMvcConfigurerAdapter {
  @Override
  public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
    // TODO Auto-generated method stub
    configurer.setDefaultTimeout(5000);
  }
  
  @Bean
  public InternalResourceViewResolver internalResourceViewResolver() {
    return new InternalResourceViewResolver("/", ".jsp");
  }
  
  @Bean
  public MultipartResolver multipartResolver() {
    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
    multipartResolver.setDefaultEncoding("UTF-8");
    multipartResolver.setMaxInMemorySize(10485760);
    multipartResolver.setMaxUploadSize(10485760);
    multipartResolver.setMaxUploadSizePerFile(10485760);
    return multipartResolver;
  }

  @Bean
  public TaskExecutor taskExcutor() {
    ThreadPoolTaskExecutor excutor = new ThreadPoolTaskExecutor();
    excutor.setCorePoolSize(3);
    excutor.setMaxPoolSize(5);
    excutor.setQueueCapacity(10);
    return excutor;
  }
}
