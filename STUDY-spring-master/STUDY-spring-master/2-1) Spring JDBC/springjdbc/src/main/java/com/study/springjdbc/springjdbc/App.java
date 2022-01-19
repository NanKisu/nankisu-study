package com.study.springjdbc.springjdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.springjdbc.config.AppContext;
import com.study.springjdbc.service.AccountService;

/**
 * Hello world!
 *
 */
public class App 
{
	  public static void main(String[] args) throws Exception {
		    ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
		    final AccountService accountService = context.getBean(AccountService.class);
		    Thread t1 = new Thread() {
		      public void run() {
		        for (int i = 0; i < 10000; i++) {
		          accountService.taskA();
		        }
		      }
		    };
		    Thread t2 = new Thread() {
		      public void run() {
		        for (int i = 0; i < 10000; i++) {
					accountService.taskA();
		        }
		      }
		    };
		    Thread t3 = new Thread() {
		    	public void run() {
		    		for (int i = 0; i < 10000; i++) {
		    			try {
							accountService.taskB();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    		}
		    	}
		    };
		    Thread t4 = new Thread() {
		    	public void run() {
		    		for (int i = 0; i < 10000; i++) {
		    			try {
							accountService.taskB();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    		}
		    	}
		    };

		    t1.start();
		    t2.start();
		    t3.start();
		    t4.start();
		  }
}
