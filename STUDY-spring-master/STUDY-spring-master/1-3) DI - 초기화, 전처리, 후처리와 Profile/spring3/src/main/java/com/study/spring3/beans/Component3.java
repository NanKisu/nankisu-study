package com.study.spring3.beans;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(scopeName = "prototype")
public class Component3 {
	
	public Component3() {
		System.out.println("Component3 Constructor");
	}

	@Override
	public String toString() {
		return "Component3 []";
	}
	
	void postConstructor() {
		System.out.println("Component3 postConstructor");
	}
	
	void preDestroy() {
		System.out.println("Component3 preDestroy");
	}
}