package com.springwebmvc.init;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import com.springwebmvc.config.AppContextConfig;
import com.springwebmvc.config.DispatcherServletContextConfig;

public class Init implements WebApplicationInitializer{

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    // TODO Auto-generated method stub
    addListener(servletContext);
    addServlet(servletContext);
    addFilter(servletContext);
  }
  
  public void addListener(ServletContext servletContext)  {
    System.out.println("run addListener...");
    AnnotationConfigWebApplicationContext webAppContext = new AnnotationConfigWebApplicationContext();
    webAppContext.register(AppContextConfig.class);
    ContextLoaderListener contextLoaderListener = new ContextLoaderListener(webAppContext);
    servletContext.addListener(contextLoaderListener);
  }
  
  public void addServlet(ServletContext servletContext)  {
    System.out.println("run addServlet...");
    AnnotationConfigWebApplicationContext webAppContext = new AnnotationConfigWebApplicationContext();
    webAppContext.register(DispatcherServletContextConfig.class);
    DispatcherServlet dispatcherServlet = new DispatcherServlet(webAppContext);
    ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet", dispatcherServlet);
    myServlet.setLoadOnStartup(1);
    myServlet.setAsyncSupported(true);
    myServlet.addMapping("/");
  }
  
  public void addFilter(ServletContext servletContext)  {
    System.out.println("run addFilter...");
    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
    FilterRegistration.Dynamic myFilter = servletContext.addFilter("myFilter", characterEncodingFilter);
    myFilter.addMappingForUrlPatterns(null, true, "/*");
    myFilter.setAsyncSupported(true);
  }
  
}
