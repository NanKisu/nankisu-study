package com.study.spring.springmybatis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {WebMvcConfig.class, DBConfig.class})
public class DispatcherServletConfig{
}
