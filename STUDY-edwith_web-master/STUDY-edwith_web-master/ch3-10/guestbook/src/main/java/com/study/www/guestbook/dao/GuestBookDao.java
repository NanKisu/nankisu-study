package com.study.www.guestbook.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.study.www.guestbook.dto.GuestBook;

import static com.study.www.guestbook.dao.GuestBookDaoSqls.*;

@Repository
public class GuestBookDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<GuestBook> rowMapper = BeanPropertyRowMapper.newInstance(GuestBook.class);
	
	public GuestBookDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("guestbook").usingGeneratedKeyColumns("id");
	}
	
	public List<GuestBook> selectAll(Integer start, Integer limit){
		Map<String,Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_PAGING, params, rowMapper);
	}
	
	public long insert(GuestBook guestbook) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(guestbook);
		return insertAction.executeAndReturnKey(params).longValue();
	}
	
	public int deleteById(Long id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.update(DELETE_BY_ID, params);
	}
	
	public int selectCount() {
		return jdbc.queryForObject(SELECT_COUNT, Collections.emptyMap(), Integer.class);
	}
}
