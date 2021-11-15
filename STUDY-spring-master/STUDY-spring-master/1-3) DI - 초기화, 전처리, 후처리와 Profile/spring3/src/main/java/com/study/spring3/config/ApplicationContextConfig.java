package com.study.spring3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = {"one", "two"})
@ComponentScan(basePackages = {"com.study.spring3.beans", "com.study.spring3.bpp"})
public class ApplicationContextConfig{

}
