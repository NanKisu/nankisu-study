package com.study.spring2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.study.spring2.beans.Component1;
import com.study.spring2.beans.Component2;

@Configuration
@ComponentScan(
	basePackages = {"com.study.spring2.beans"},  
	useDefaultFilters = false,
	includeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*Component.*")},
	excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {Component1.class})}
)
public class AppConfig6 {
}
