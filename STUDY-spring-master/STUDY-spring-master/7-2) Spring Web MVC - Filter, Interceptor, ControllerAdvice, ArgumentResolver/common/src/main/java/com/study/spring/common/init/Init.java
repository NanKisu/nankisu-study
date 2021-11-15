package com.study.spring.common.init;

import java.io.FilterReader;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.study.spring.common.config.AppContextConfig;
import com.study.spring.common.config.DispatcherServletContextConfig;
import com.study.spring.common.filters.MyFilter;

public class Init implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext context) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("onStartup...");
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(AppContextConfig.class);
		ContextLoaderListener listener = new ContextLoaderListener(appContext);
		context.addListener(listener);
		
		AnnotationConfigWebApplicationContext dispatcherServletContext = new AnnotationConfigWebApplicationContext();
		dispatcherServletContext.register(DispatcherServletContextConfig.class);
		DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherServletContext);
		ServletRegistration.Dynamic myServlet = context.addServlet("myServlet", dispatcherServlet);
		myServlet.setLoadOnStartup(1);
		myServlet.addMapping("/");
		
		MyFilter myFilter = new MyFilter();
		FilterRegistration.Dynamic filter = context.addFilter("filter", myFilter);
		filter.addMappingForUrlPatterns(null, true, "/*");
	}

}
