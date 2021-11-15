package com.study.webapp.rest.init;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import com.study.webapp.rest.config.AppContextConfig;
import com.study.webapp.rest.config.DispatcherServletConfig;
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
    AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
    appContext.register(AppContextConfig.class);
    ContextLoaderListener contextlistener = new ContextLoaderListener(appContext);
    servletContext.addListener(contextlistener);
  }

  public void addServlet(ServletContext servletContext) {
    log.info("run addServlet...");
    AnnotationConfigWebApplicationContext dispatcherServletContext = new AnnotationConfigWebApplicationContext();
    dispatcherServletContext.register(DispatcherServletConfig.class);
    DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherServletContext);
    dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
    ServletRegistration.Dynamic restServlet = servletContext.addServlet("restServlet", dispatcherServlet);
    restServlet.setLoadOnStartup(1);
    restServlet.addMapping("/");
  }

  public void addFilter(ServletContext servletContext) {
    log.info("run addFilter...");
    CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter("UTF-8", true);
    FilterRegistration.Dynamic restFilter = servletContext.addFilter("restFilter", encodingFilter);
    restFilter.addMappingForUrlPatterns(null, true, "/*");
  }

}
