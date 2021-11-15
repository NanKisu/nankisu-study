package com.study.webapp.pagemove.init;

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
import com.study.webapp.pagemove.config.ServletContextConfig;
import com.study.webapp.pagemove.config.WebAppContextConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Init implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    // TODO Auto-generated method stub
    log.info("onStartUp...");
    addListener(servletContext);
    addServlet(servletContext);
    addFilter(servletContext);
  }

  public void addListener(ServletContext servletContext) {
    log.info("addListener...");
    AnnotationConfigWebApplicationContext webAppContext = new AnnotationConfigWebApplicationContext();
    webAppContext.register(WebAppContextConfig.class);
    ContextLoaderListener listener = new ContextLoaderListener(webAppContext);
    servletContext.addListener(listener);
  }

  public void addServlet(ServletContext servletContext) {
    log.info("addServlet...");
    AnnotationConfigWebApplicationContext servletContextConfig = new AnnotationConfigWebApplicationContext();
    servletContextConfig.register(ServletContextConfig.class);
    DispatcherServlet dispatcherServlet = new DispatcherServlet(servletContextConfig);
    ServletRegistration.Dynamic servlet = servletContext.addServlet("servlet", dispatcherServlet);
    servlet.addMapping("/");
    servlet.setLoadOnStartup(1);
  }

  public void addFilter(ServletContext servletContext) {
    log.info("addFilter...");
    CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter("UTF-8", true);
    FilterRegistration.Dynamic filter = servletContext.addFilter("filter", encodingFilter);
    filter.addMappingForUrlPatterns(null, true, "/*");
  }

}
