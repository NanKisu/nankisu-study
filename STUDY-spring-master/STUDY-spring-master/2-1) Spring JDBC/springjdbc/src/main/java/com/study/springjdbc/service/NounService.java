package com.study.springjdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.study.springjdbc.dao.Noun001DAO;
import com.study.springjdbc.vo.Noun001;

@Service
public class NounService {
	@Autowired
	private Noun001DAO dao;
	@Autowired
	private PlatformTransactionManager txManager;
	@Autowired
	private TransactionTemplate txTemplate;
	
	@Transactional
	public void test() {
		int a;
    	System.out.println(dao.selectAll());
    	
    	Noun001 noun = new Noun001();
    	noun.setSysC("001");
    	noun.setValue("멍멍이");
    	Integer id = dao.insert(noun);
    	
    	System.out.println(dao.selectById(id));
    	
    	dao.updateById(id, "고양이");
    	a = 1/0;
    	System.out.println(dao.selectAll());
	}
	
	public void test2() {
		DefaultTransactionDefinition txDef = new DefaultTransactionDefinition();
		txDef.setName("test2TxDef");
		
		TransactionStatus status = txManager.getTransaction(txDef);
		
		try {
			int a;
			System.out.println(dao.selectAll());
	    	
	    	Noun001 noun = new Noun001();
	    	noun.setSysC("001");
	    	noun.setValue("멍멍이");
	    	Integer id = dao.insert(noun);
	    	
	    	System.out.println(dao.selectById(id));
	    	
	    	dao.updateById(id, "고양이");
	    	a = 1/0;
	    	System.out.println(dao.selectAll());
		} catch(Exception e) {
			txManager.rollback(status);
		}
		txManager.commit(status);    	
	}
	
	public void test3() {
		txTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				// TODO Auto-generated method stub
				int a;
				System.out.println(dao.selectAll());
		    	
		    	Noun001 noun = new Noun001();
		    	noun.setSysC("001");
		    	noun.setValue("멍멍이");
		    	Integer id = dao.insert(noun);
		    	
		    	System.out.println(dao.selectById(id));
		    	
		    	dao.updateById(id, "고양이");
		    	System.out.println(dao.selectAll());
			}
		});
	}
	
}
