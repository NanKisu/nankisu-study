package com.study.webapp.valiation.init;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import com.study.webapp.valiation.config.DispatcherServletContextConfig;
import com.study.webapp.valiation.config.WebAppContextConfig;

public class Init implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    // TODO Auto-generated method stub
    System.out.println("onStartup!!");
    addListener(servletContext);
    addServlet(servletContext);
    addFilter(servletContext);
  }

  public void addListener(ServletContext servletContext) {
    AnnotationConfigWebApplicationContext webAppContext = new AnnotationConfigWebApplicationContext();
    webAppContext.register(WebAppContextConfig.class);
    ContextLoaderListener webAppListener = new ContextLoaderListener(webAppContext);
    servletContext.addListener(webAppListener);
  }

  public void addServlet(ServletContext servletContext) {
    AnnotationConfigWebApplicationContext dispatcherServletContext = new AnnotationConfigWebApplicationContext();
    dispatcherServletContext.register(DispatcherServletContextConfig.class);
    DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherServletContext);
    ServletRegistration.Dynamic myDispatcherServlet = servletContext.addServlet("myDispatcherServlet", dispatcherServlet);
    myDispatcherServlet.setLoadOnStartup(1);
    myDispatcherServlet.addMapping("/");
  }

  public void addFilter(ServletContext servletContext) {
    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
    FilterRegistration.Dynamic myCharacterEncodingFilter = servletContext.addFilter("myCharacterEncodingFilter", characterEncodingFilter);
    myCharacterEncodingFilter.addMappingForUrlPatterns(null, true, "/*");
  }
}
