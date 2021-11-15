package com.study.spring1.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("bean1")
public class Bean1 {
	private String name;
	
	public Bean1() {
		super();
		System.out.println("Bean1 Constructor");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
