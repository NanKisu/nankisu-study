package com.study.spring2.spring2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.spring2.beans.Component1;
import com.study.spring2.beans.Component2;
import com.study.spring2.beans.Scope_Singleton;
import com.study.spring2.config.AppConfig1;
import com.study.spring2.config.AppConfig2;
import com.study.spring2.config.AppConfig3;
import com.study.spring2.config.AppConfig4;
import com.study.spring2.config.AppConfig5;
import com.study.spring2.config.AppConfig6;
import com.study.spring2.config.AppConfig7;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig7.class);
    	Scope_Singleton ss = context.getBean(Scope_Singleton.class);
    	ss.action();
    	Scope_Singleton ss2 = context.getBean(Scope_Singleton.class);
    	ss2.action();
    	
        System.out.println( "Hello World!" );
    }
}
