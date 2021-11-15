package com.study.spring3.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public class Component2 {
	@Autowired
	private Component1 comp1;
	
	public Component2() {
		System.out.println("Component2 Constructor");
	}
	
	public Component1 getComp1() {
		return comp1;
	}
	public void setStr(Component1 comp1) {
		this.comp1 = comp1;
	}

	@Override
	public String toString() {
		return "Component2 [comp1=" + comp1 + "]";
	}
	
	@PostConstruct
	void postConstructor() {
		System.out.println("Component2 postConstructor");
	}
	
	@PreDestroy
	void preDestroy() {
		System.out.println("Component2 preDestroy");
	}
}
