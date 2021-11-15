package com.study.spring.config;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.study.spring.controller"})
public class DispatcherServletContextConfig extends WebMvcConfigurerAdapter{  
//  @Override
//  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//    // TODO Auto-generated method stub
//    super.configureDefaultServletHandling(configurer);
//    configurer.enable();
//  }
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // TODO Auto-generated method stub
    super.addResourceHandlers(registry);
    registry.addResourceHandler("**.txt").addResourceLocations("/").setCachePeriod(604800);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // TODO Auto-generated method stub
    super.addInterceptors(registry);
    registry.addInterceptor(new LocaleChangeInterceptor()).addPathPatterns("/**");
  }

  @Bean
  public InternalResourceViewResolver internalResourceViewResolver() {
    return new InternalResourceViewResolver("/", ".jsp");
  }
  
  @Bean
  public LocaleResolver localeResolver() {
    CookieLocaleResolver localeResolver = new CookieLocaleResolver();
    localeResolver.setCookieName("locale");
    localeResolver.setDefaultLocale(Locale.KOREA);
    return localeResolver;
  }
}
