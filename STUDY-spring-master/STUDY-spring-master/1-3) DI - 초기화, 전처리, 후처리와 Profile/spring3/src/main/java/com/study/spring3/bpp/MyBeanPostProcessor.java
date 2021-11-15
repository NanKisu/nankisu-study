package com.study.spring3.bpp;

import java.util.Objects;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.study.spring3.beans.Component1;
import com.study.spring3.beans.Component2;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("[Before Initialization]");
		if(bean instanceof Component1) {
			System.out.println(bean);
			((Component1)bean).setStr("standalone");
		}
		else if(bean instanceof Component2) {
			System.out.println(bean);
			((Component2)bean).getComp1().setStr("forComp2");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("[After Initialization]");
		if(bean instanceof Component1) {
			System.out.println(bean);
		}
		else if(bean instanceof Component2) {
			System.out.println(bean);
		}
		return bean;
	}
	
}
