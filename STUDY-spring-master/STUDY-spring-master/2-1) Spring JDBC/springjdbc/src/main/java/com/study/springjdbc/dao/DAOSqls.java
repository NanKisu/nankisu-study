package com.study.springjdbc.dao;

public class DAOSqls {
	  public static final String ACCOUNT_SELECT_ALL = "select id, balance from Account";
	  public static final String ACCOUNT_SELECT_BY_ID =
	      "select id, balance from Account where id = :id";
	  public static final String ACCOUNT_UPDATE_BY_ID =
	      "update Account set balance = :balance where id = :id";
	  public static final String ACCOUNT_DELETE_BY_ID = "delete from Account where id = :id";
	}