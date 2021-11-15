package com.study.spring.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {SecurityConfig.class})
public class DispatcherServletContextConfig{

}
