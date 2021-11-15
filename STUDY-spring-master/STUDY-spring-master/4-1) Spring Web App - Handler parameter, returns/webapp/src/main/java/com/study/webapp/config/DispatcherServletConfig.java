package com.study.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.util.UrlPathHelper;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.study.webapp.controller"})
public class DispatcherServletConfig extends WebMvcConfigurerAdapter {
  
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    // TODO Auto-generated method stub
    registry.addViewController("/addviewcontroller").setViewName("home");
    registry.addStatusController("/addstatuscontroller", HttpStatus.ACCEPTED);
    registry.addRedirectViewController("/addredirectviewcontroller", "/");
    
  }

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    // TODO Auto-generated method stub
    UrlPathHelper urlPathHelper = new UrlPathHelper();
    urlPathHelper.setRemoveSemicolonContent(false);
    configurer.setUrlPathHelper(urlPathHelper);
  }

  @Bean
  public InternalResourceViewResolver internalResourceViewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/views/");
    resolver.setSuffix(".jsp");
    return resolver;
  }
}
