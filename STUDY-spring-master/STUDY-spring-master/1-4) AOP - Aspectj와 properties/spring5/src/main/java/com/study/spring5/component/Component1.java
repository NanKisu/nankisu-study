package com.study.spring5.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Component1 {
	@Value("${param1}:null")
	private String param1;
	@Value("${param2}")
	private String param2;
	
	public void method1() {
	}
	
	public Component1 method2(Integer num) {
		return this;
	}

	public void method3() throws Exception {
		throw new Exception("Method3 Exception");
	}
	
	public void method4(Integer num) {
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	@Override
	public String toString() {
		return "Component1 [param1=" + param1 + ", param2=" + param2 + "]";
	}	
	
	
}
