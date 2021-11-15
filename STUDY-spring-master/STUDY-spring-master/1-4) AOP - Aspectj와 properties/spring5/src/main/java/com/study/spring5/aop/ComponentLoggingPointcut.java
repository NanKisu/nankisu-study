package com.study.spring5.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class ComponentLoggingPointcut {
	public static final String componentMethod = "execution(* *..*Component1.*(..))";
	
	@Pointcut("execution(* *..*Component1.*(..))")
	public void componentMethod2() {}
}
