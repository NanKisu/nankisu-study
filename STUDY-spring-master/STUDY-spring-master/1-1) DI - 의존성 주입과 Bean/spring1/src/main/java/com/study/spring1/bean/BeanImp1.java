package com.study.spring1.bean;

import org.springframework.stereotype.Component;

@Component
public class BeanImp1 implements CommonBean {
	public BeanImp1() {
		System.out.println("BeanImp1 constructor");
	}
}
