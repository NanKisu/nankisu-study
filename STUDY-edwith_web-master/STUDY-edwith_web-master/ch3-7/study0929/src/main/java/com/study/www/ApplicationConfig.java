package com.study.www;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfig {
	@Bean
	public Car car(Engine e) {
		Car car = new Car(); 
		car.setEngine(e);
		return car;
	}
	
	@Bean
	public Engine engine() {
		return new Engine();
	}
}
