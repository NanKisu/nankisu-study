package com.study.spring2.beans;

import org.springframework.stereotype.Component;

@Component
public class Component1 {
	private String str;
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Component1() {
		System.out.println("Component1 constructor");
	}
}
