package com.study.spring3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.spring3.beans.Component1;
import com.study.spring3.beans.Component2;
import com.study.spring3.beans.Component3;
import com.study.spring3.config.AppConfig;
import com.study.spring3.config.ApplicationContextConfig;
import com.study.spring3.config.ApplicationContextConfig2;

public class Spring3 {
	public static void main(String[] args) {
//		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);		
//		Component2 comp2 = context.getBean("component2", Component2.class);
//		context.close();		
			
//		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig2.class);		
//		Component3 comp3 = context.getBean("component3", Component3.class);
//		System.out.println(comp3);	
//		context.close();

		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);		
		Component3 comp3 = context.getBean("component3", Component3.class);
		System.out.println(comp3);	
		context.close();
	}
}
