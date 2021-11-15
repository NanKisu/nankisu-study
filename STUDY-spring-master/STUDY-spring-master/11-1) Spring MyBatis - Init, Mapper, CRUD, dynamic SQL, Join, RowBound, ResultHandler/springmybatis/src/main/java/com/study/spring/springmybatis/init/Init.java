package com.study.spring.springmybatis.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import com.study.spring.springmybatis.config.AppConfig;
import com.study.spring.springmybatis.config.DispatcherServletConfig;

public class Init  implements WebApplicationInitializer{

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext webAppContext = new AnnotationConfigWebApplicationContext();
    webAppContext.register(AppConfig.class);
    ContextLoaderListener contextLoaderListener =  new ContextLoaderListener(webAppContext);
    servletContext.addListener(contextLoaderListener);
    
    AnnotationConfigWebApplicationContext dispatcherServletConfig = new AnnotationConfigWebApplicationContext();
    dispatcherServletConfig.register(DispatcherServletConfig.class);
    DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherServletConfig);
    ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet", dispatcherServlet);
    myServlet.addMapping("/");
  } 

}
