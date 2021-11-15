package com.study.spring1.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BeanImp2 implements CommonBean {
	public BeanImp2() {
		System.out.println("BeanImp2 constructor");
	}
}
