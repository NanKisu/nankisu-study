package com.study.nankisu.springbatch.dao;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public Integer getCount() {
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM ROOM",  Collections.EMPTY_MAP, Integer.class);
	}
}
