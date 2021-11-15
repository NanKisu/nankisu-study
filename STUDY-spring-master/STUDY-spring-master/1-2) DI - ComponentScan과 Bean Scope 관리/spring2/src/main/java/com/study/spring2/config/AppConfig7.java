package com.study.spring2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.study.spring2.beans.Component1;
import com.study.spring2.beans.Component2;

@Configuration
@ComponentScan(
	basePackages = {"com.study.spring2.beans"},  
	useDefaultFilters = false,
	includeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*Scope.*")}
)
public class AppConfig7 {
	
}
