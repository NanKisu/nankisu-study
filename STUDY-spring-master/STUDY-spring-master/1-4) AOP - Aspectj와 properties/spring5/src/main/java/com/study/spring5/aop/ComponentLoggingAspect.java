package com.study.spring5.aop;

import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.study.spring5.aop.ComponentLoggingPointcut.*;
import com.study.spring5.component.Component1;

@Aspect
@Component
public class ComponentLoggingAspect {
	
//	@Before(value = ComponentLoggingPointcut.componentMethod)
//	public void methodStartLog(JoinPoint jp) {
//		System.out.println("[MethodStartLog] " + jp.getSignature());
//	}
//	
//	@AfterReturning(value = "ComponentLoggingPointcut.componentMethod2()", returning = "comp")
//	public void methodReturnLog(JoinPoint jp, Component1 comp) {
//		System.out.println("[MethodReturnLog] " + jp.getSignature() + ", " + comp);		
//	}
//	
//	@AfterThrowing(value = "execution(* *..*Component1.*(..))", throwing = "e")
//	public void methodThrowLog(JoinPoint jp, Exception e) {
//		System.out.println("[MethodThrowLog] " + jp.getSignature() + ", " + e.toString());		
//	}
//	
//	@Around(value = "execution(* *..*Component1.*(..))")
//	public Object methodAroundLog(ProceedingJoinPoint jp) {
//		System.out.println("[MethodAround] " + jp.getSignature());
//		Object obj = null;
//		try {
//			obj = jp.proceed();
//			
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			System.out.println("[/MethodAround]");
//		}
//		return obj;
//	}
//	@Around(value = "execution(* *..component.*.*(..))")
//	public void methodAroundLog(ProceedingJoinPoint jp) {
//		System.out.println("[MethodAround] " + jp.getSignature());
//		System.out.println("This : " + jp.getThis().toString());
//		System.out.println("Target : " + jp.getTarget().toString());
//		System.out.println("Args : " + (Integer)jp.getArgs()[0]);
//		
//		try {
//			jp.proceed();
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
