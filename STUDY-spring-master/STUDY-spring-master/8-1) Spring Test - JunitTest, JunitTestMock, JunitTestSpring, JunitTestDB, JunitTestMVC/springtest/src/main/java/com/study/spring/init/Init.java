package com.study.spring.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import com.study.spring.config.AppContextConfig;
import com.study.spring.config.DispatcherServletContextConfig;

public class Init implements WebApplicationInitializer{

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    // TODO Auto-generated method stub
    addListener(servletContext);
    addServlet(servletContext);
  }

  private void addListener(ServletContext servletContext) {
    AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
    appContext.register(AppContextConfig.class);
    ContextLoaderListener listener = new ContextLoaderListener(appContext);
    servletContext.addListener(listener);
  }

  private void addServlet(ServletContext servletContext) {
    AnnotationConfigWebApplicationContext dispatcherServletContext = new AnnotationConfigWebApplicationContext();
    dispatcherServletContext.register(DispatcherServletContextConfig.class);
    DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherServletContext);
    ServletRegistration.Dynamic mySerlvet = servletContext.addServlet("myServlet", dispatcherServlet);
    mySerlvet.addMapping("/");
    mySerlvet.setLoadOnStartup(1);
  }
}
