package com.study.spring2.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class Scope_Singleton {
	@Autowired Scope_Prototype sp;
	
	public Scope_Singleton() {
		System.out.println("Scope_Singleton constructor");
	}
	
	public void action() {
//		Scope_Prototype sp = getSP();
		sp.action();
		System.out.println("Action");
	}
	
//	@Lookup
//	protected Scope_Prototype getSP() {
//		return null;
//	}
}
