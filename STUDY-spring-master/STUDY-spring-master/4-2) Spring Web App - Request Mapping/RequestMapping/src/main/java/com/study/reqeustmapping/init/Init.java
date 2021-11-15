package com.study.reqeustmapping.init;

import javax.servlet.FilterRegistration;
import javax.servlet.Registration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import com.study.reqeustmapping.config.AppContext;
import com.study.reqeustmapping.config.WebContext;

public class Init implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    // TODO Auto-generated method stub
    System.out.println("OnStartUp!!!");
    addContextLoader(servletContext);
    addDispatcherServlet(servletContext);
    addEncodingFilter(servletContext);
  }

  public void addContextLoader(ServletContext servletContext) {
    AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
    webApplicationContext.register(AppContext.class);
    ContextLoaderListener contextLoaderListener = new ContextLoaderListener(webApplicationContext);
    servletContext.addListener(contextLoaderListener);
  }

  public void addDispatcherServlet(ServletContext servletContext) {
    AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
    webApplicationContext.register(WebContext.class);
    DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
    ServletRegistration.Dynamic webServlet = servletContext.addServlet("webServlet", dispatcherServlet);
    webServlet.setLoadOnStartup(1);
    webServlet.addMapping("/");
  }
  
  public void addEncodingFilter(ServletContext servletContext) {
    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
    FilterRegistration.Dynamic webFilter = servletContext.addFilter("webFilter", characterEncodingFilter);
    webFilter.addMappingForUrlPatterns(null, true, "/*");
  }

}
