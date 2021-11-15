package com.study.springmvcwithoutxml.init;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import com.study.springmvcwithoutxml.config.AppConfig;
import com.study.springmvcwithoutxml.config.WebAppConfig;

public class Init implements WebApplicationInitializer{

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    // TODO Auto-generated method stub
    servletContext.addListener(contextListener());
    
    ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("dispatcher", dispatcherServlet());
    servletRegistration.setLoadOnStartup(1);
    servletRegistration.addMapping("/");
    
    FilterRegistration.Dynamic filter = servletContext.addFilter("CharacterEncoding", new CharacterEncodingFilter("UTF-8", true));
    filter.addMappingForUrlPatterns(null, true, "/*");
  }
  
  private ContextLoaderListener contextListener() {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.register(AppConfig.class); 
    return new ContextLoaderListener(context);
  }
  
  private DispatcherServlet dispatcherServlet() {
    AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
    webContext.register(WebAppConfig.class);
    return new DispatcherServlet(webContext);
  }
}
