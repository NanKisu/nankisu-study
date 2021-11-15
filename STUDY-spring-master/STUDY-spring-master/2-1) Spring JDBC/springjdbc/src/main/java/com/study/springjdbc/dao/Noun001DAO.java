package com.study.springjdbc.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import com.study.springjdbc.vo.Noun001;

import static com.study.springjdbc.dao.DAOSqls.*;

@Component
public class Noun001DAO {
	private NamedParameterJdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert insert;
	
	public Noun001DAO(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		insert = new SimpleJdbcInsert(dataSource).withTableName("Noun001").usingColumns("sys_c", "value").usingGeneratedKeyColumns("id");
	}
	
	public Integer insert(Noun001 noun) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(noun);
		return insert.executeAndReturnKey(params).intValue();
	}
	
	public List<Noun001> selectAll(){
		return jdbcTemplate.query(NOUN001_SELECT_ALL, Collections.EMPTY_MAP, BeanPropertyRowMapper.newInstance(Noun001.class));
	}
	
	public List<Noun001> selectById(Integer id){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return jdbcTemplate.query(NOUN001_SELECT_BY_ID, params, BeanPropertyRowMapper.newInstance(Noun001.class));
	}
	
	public Integer updateById(Integer id, String value){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("value", value);
		return jdbcTemplate.update(NOUN001_UPDATE_BY_ID, params);
	}
	
	public Integer deleteById(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return jdbcTemplate.update(NOUN001_DELETE_BY_ID, params);
	}
}
