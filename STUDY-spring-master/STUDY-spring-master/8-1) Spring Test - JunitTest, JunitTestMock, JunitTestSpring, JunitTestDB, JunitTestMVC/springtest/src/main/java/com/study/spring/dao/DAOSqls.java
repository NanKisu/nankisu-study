package com.study.spring.dao;

public class DAOSqls {
	public static final String NOUN001_SELECT_ALL = "select sys_c, id, value from Noun001";
	public static final String NOUN001_SELECT_BY_ID = "select sys_c, id, value from Noun001 where id = :id";
	public static final String NOUN001_UPDATE_BY_ID = "update Noun001 set value = :value where id = :id";
	public static final String NOUN001_DELETE_BY_ID = "delete from Noun001 where id = :id";
}
