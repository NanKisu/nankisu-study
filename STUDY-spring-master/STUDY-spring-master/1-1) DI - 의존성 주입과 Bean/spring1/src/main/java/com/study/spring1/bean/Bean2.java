package com.study.spring1.bean;

import org.springframework.stereotype.Component;

@Component("bean2")
public class Bean2 {
	private String name;
	
	public Bean2() {
		super();
		System.out.println("Bean2 Constructor");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
