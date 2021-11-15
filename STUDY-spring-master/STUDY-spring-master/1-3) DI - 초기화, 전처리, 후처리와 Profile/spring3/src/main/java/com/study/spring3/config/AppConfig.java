package com.study.spring3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.study.spring3.beans.Component3;

@Configuration
@Import(value = {ApplicationContextConfig.class, ApplicationContextConfig2.class})
public class AppConfig{
}
