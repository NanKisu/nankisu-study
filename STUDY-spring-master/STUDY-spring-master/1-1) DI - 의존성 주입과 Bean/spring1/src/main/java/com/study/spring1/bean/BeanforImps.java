package com.study.spring1.bean;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BeanforImps{
	@Autowired @Resource CommonBean bean;
	
	public BeanforImps() {
		System.out.println("BeanforImps constructor");
	}
}
