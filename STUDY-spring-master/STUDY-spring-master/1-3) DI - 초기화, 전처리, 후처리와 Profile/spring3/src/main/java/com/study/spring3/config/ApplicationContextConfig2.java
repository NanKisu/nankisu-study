package com.study.spring3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.study.spring3.beans.Component3;

@Configuration
@Profile(value = {"three"})
@ComponentScan(basePackages = {"com.study.spring3.bpp"})
public class ApplicationContextConfig2{
	@Bean(destroyMethod = "preDestroy", initMethod = "postConstructor")
	public Component3 component3() {
		return new Component3();
	}
}
