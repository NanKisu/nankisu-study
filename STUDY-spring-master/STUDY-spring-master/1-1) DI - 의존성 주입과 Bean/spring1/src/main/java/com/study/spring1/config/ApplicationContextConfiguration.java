package com.study.spring1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.study.spring1.bean.Bean1;
import com.study.spring1.bean.Bean2;
import com.study.spring1.bean.Bean3;

@Configuration
@ComponentScan({"Component})
public class ApplicationContextConfiguration {
	@Bean
	public Bean1 bean1() {
		return new Bean1();
	}
	
	@Bean
	public Bean2 bean2() {
		return new Bean2();
	}
	
	@Bean
	public Bean3 bean3() {
		return new Bean3(bean1(), bean2());
	}
}
