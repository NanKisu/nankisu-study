package com.study.spring1.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BeanforImps2{
	@Autowired @Qualifier("beanImp2") CommonBean bean;
	
	public BeanforImps2() {
		System.out.println("BeanforImps constructor");
	}
}
