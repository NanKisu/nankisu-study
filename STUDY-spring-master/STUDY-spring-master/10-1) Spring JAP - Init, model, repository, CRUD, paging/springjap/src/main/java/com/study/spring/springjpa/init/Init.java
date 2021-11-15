package com.study.spring.springjpa.init;

import javax.servlet.Registration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import com.study.spring.springjpa.config.AppConfig;
import com.study.spring.springjpa.config.WebMvcConfig;

public class Init implements WebApplicationInitializer{

  public void onStartup(ServletContext servletContext) throws ServletException {
    // TODO Auto-generated method stub
    
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.register(AppConfig.class);
    ContextLoaderListener listener = new ContextLoaderListener(context);
    servletContext.addListener(listener);
    
    AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
    webContext.register(WebMvcConfig.class);
    DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);
    ServletRegistration.Dynamic appServlet= servletContext.addServlet("appServlet", dispatcherServlet);
    appServlet.addMapping("/*");
    
  }

}
