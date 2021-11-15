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

public class Init implements WebApplicationInitializer {
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    // TODO Auto-generated method stub
    System.out.println("onStartup...");
    addListener(servletContext);
    addServlet(servletContext);
  }

  public void addListener(ServletContext servletContext) {
    System.out.println("addListener...");
    AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
    appContext.register(AppContextConfig.class);
    ContextLoaderListener loaderListener = new ContextLoaderListener(appContext);
    servletContext.addListener(loaderListener);
  }

  public void addServlet(ServletContext servletContext) {
    System.out.println("addListener...");
    AnnotationConfigWebApplicationContext dispatcherServletAppContext = new AnnotationConfigWebApplicationContext();
    dispatcherServletAppContext.register(DispatcherServletContextConfig.class);
    DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherServletAppContext);
    ServletRegistration.Dynamic mySerlvet = servletContext.addServlet("myServlet", dispatcherServlet);
    mySerlvet.setLoadOnStartup(1);
    mySerlvet.addMapping("/");
  }
}
