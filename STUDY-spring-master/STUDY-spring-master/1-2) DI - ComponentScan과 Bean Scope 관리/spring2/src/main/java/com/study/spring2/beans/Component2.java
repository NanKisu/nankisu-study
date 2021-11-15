package com.study.spring2.beans;

import org.springframework.context.annotation.Scope;

@Scope(scopeName = "prototype")
public class Component2 {
	private String str;
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Component2() {
		System.out.println("Component2 constructor");
	}
}
