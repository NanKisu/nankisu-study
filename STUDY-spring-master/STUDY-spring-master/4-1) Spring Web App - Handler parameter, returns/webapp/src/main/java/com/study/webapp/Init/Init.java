package com.study.webapp.Init;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import com.study.webapp.config.AppConfig;
import com.study.webapp.config.DispatcherServletConfig;

public class Init implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    // TODO Auto-generated method stub
    setContextLoader(servletContext);
    setDispatcherServlet(servletContext);
    setFilter(servletContext);
  }

  private void setContextLoader(ServletContext servletContext) {
    AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
    appContext.register(AppConfig.class);
    ContextLoaderListener contextLoader = new ContextLoaderListener(appContext);
    servletContext.addListener(contextLoader);
  }
  
  private void setDispatcherServlet(ServletContext servletContext) {
    AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
    appContext.register(DispatcherServletConfig.class);
    ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(appContext));
    dispatcherServlet.setLoadOnStartup(1);
    dispatcherServlet.addMapping("/");
  }
  
  private void setFilter(ServletContext servletContext) {
    FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter("UTF-8", true));
    characterEncodingFilter.addMappingForUrlPatterns(null, false, "/*");
  }
}
