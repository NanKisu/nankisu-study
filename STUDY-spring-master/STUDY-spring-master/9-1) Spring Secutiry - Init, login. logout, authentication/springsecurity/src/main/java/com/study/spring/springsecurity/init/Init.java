package com.study.spring.springsecurity.init;

import javax.servlet.Filter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.study.spring.springsecurity.config.DBConfig;
import com.study.spring.springsecurity.config.WebMvcConfig;

public class Init 
                extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }
 
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebMvcConfig.class, DBConfig.class};
    }
 
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
 
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] {
                new DelegatingFilterProxy("springSecurityFilterChain")
        };
    }
}
