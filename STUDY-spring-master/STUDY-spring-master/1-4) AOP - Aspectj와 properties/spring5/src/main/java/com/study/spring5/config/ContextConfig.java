package com.study.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.study.spring5.component", "com.study.spring5.aop"})
@EnableAspectJAutoProxy
@Import(value = PropertiesConfig.class)
public class ContextConfig{
}
