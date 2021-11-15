package com.study.spring3.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "singleton")
public class Component1 {
	private String str;
	
	public Component1() {
		System.out.println("Component1 Constructor");
	}
	
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return "Component1 [str=" + str + "]";
	}
	
	@PostConstruct
	void postConstructor() {
		System.out.println("Component1 postConstructor");
	}
	
	@PreDestroy
	void preDestroy() {
		System.out.println("Component1 preDestroy");
	}
}
