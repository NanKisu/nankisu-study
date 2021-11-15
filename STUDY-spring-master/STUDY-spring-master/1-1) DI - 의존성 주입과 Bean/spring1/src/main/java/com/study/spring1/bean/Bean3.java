package com.study.spring1.bean;

import java.beans.ConstructorProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Bean3 {
	private Bean1 bean1;
	private Bean2 bean2;
	
	@Autowired
	public Bean3(Bean1 bean3, Bean2 bean4) {
		this.bean1 = new Bean1();
		this.bean2 = new Bean2();
		this.bean1 = bean3;
		this.bean2 = bean4;
		System.out.println("Bean3 Constructor");
	}
	
	public Bean1 getBean1() {
		return bean1;
	}

	public Bean2 getBean2() {
		return bean2;
	}
	
}
