package com.study.spring1.spring1;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.spring1.bean.Bean3;
import com.study.spring1.bean.CommonBean;
import com.study.spring1.config.ApplicationContextConfiguration;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
    	// 1. Dependancy Injection
    	// Bean 정의 방식 1) Java Config, 2) xml 파일, 3) Annotation 방식
    	// Bean 의존성 주입 방식 1) 설정자 기반, 2) 생성자 기반, 3) 필드 기반
    	// 타입이 같은 bean을 구분 할 때, @primary, @Qualifier, @Resource
    	// @Autoweird Map<String, CommonBean> beans_map 도 가능
    	ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfiguration.class);
    	
    	Bean3 bean3 = context.getBean(Bean3.class);
    	Bean3 bean3_2 = context.getBean(Bean3.class);
    	Map<String, CommonBean> beans_map = context.getBeansOfType(CommonBean.class);
    	
    	System.out.println(bean3.getBean1().getName());
    	bean3_2.getBean1().setName("temp");
    	System.out.println(bean3.getBean1().getName());
    	
    	System.out.println(beans_map);
    }
}
