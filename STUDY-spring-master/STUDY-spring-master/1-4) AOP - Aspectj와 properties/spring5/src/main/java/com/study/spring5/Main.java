package com.study.spring5;

import java.util.Date;
import java.util.Timer;

import org.apache.commons.logging.impl.ServletContextCleaner;
import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.spring5.component.Component1;
import com.study.spring5.config.ContextConfig;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);
//		Component1 comp1 = context.getBean("component1", Component1.class);
//		comp1.method1();
//		System.out.println(comp1.method2(10));
//		try {
//			comp1.method3();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		comp1.method4(10);
		ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);
		Component1 comp1 = context.getBean("component1", Component1.class);
		System.out.println(comp1);
	}

}
