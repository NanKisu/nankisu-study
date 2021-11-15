package com.study.spring2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.study.spring2.beans.Component2;

@Configuration
@ComponentScan(
	basePackages = {"com.study.spring2.beans"},  
	includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {Component2.class})}
)
public class AppConfig2 {
	
}
