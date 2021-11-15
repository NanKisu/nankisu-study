package com.study.webapp.exception.init;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import com.study.webapp.exception.config.AppContextConfig;
import com.study.webapp.exception.config.ServletContextConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Init implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    // TODO Auto-generated method stub
    addListener(servletContext);
    addServlet(servletContext);
    addFilter(servletContext);
  }

  public void addListener(ServletContext servletContext) {
    log.info("run addListener...");
    AnnotationConfigWebApplicationContext webAppContext = new AnnotationConfigWebApplicationContext();
    webAppContext.register(AppContextConfig.class);
    ContextLoaderListener contextLoaderListener = new ContextLoaderListener(webAppContext);
    servletContext.addListener(contextLoaderListener);
  }

  public void addServlet(ServletContext servletContext) {
    log.info("run addServlet...");
    AnnotationConfigWebApplicationContext webAppContext = new AnnotationConfigWebApplicationContext();
    webAppContext.register(ServletContextConfig.class);
    DispatcherServlet dispatcherServlet = new DispatcherServlet(webAppContext);
    dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
    ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet", dispatcherServlet);
    myServlet.addMapping("/");
    myServlet.setLoadOnStartup(1);
  }

  public void addFilter(ServletContext servletContext) {
    log.info("run addServlet...");
    CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter("UTF-8", true);
    FilterRegistration.Dynamic myFilter = servletContext.addFilter("myFilter", encodingFilter);
    myFilter.addMappingForUrlPatterns(null, true, "/*");
  }

}
