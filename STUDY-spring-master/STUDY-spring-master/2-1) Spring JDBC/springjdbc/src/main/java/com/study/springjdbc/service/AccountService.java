package com.study.springjdbc.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.study.springjdbc.dao.AccountDAO;
import com.study.springjdbc.vo.Account;

@Service
public class AccountService {
  @Autowired
  private AccountDAO dao;
  @Transactional(isolation = Isolation.REPEATABLE_READ)
  public void taskA() {
	  System.out.println("출금중");
    Account account = dao.selectById(0).get(0);
    account.setBalance(account.getBalance() - 100);
    dao.update(account);
    account.setBalance(account.getBalance() - 100);
    dao.update(account);
    try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    account.setBalance(account.getBalance() - 100);
    dao.update(account);
    
    System.out.println("출금끝");
  }
  	
  @Transactional(isolation = Isolation.REPEATABLE_READ)
  	public Map<String, Object> taskB() throws InterruptedException {
		Map<String, Object> result = new HashMap<String, Object>();
		Account account = dao.selectById(0).get(0);
		result.put("isOver100", account.getBalance() > 100);
		result.put("curBalance1", account.getBalance());
		Account cur_account = dao.selectById(0).get(0);
		result.put("curBalance2", cur_account.getBalance());
		cur_account = dao.selectById(0).get(0);
		result.put("curBalance3", cur_account.getBalance());
		cur_account = dao.selectById(0).get(0);
		result.put("curBalance4", cur_account.getBalance());
		System.out.println(result);
		return result;
	  }
}
