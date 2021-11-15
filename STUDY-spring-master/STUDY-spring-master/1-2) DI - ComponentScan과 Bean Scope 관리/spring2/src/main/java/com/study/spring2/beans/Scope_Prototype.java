package com.study.spring2.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Scope_Prototype {
	public Scope_Prototype() {
		System.out.println("Scope_Prototype constructor");
	}
	
	public void action() {
		System.out.println("ProtoType Action");
	}
}
