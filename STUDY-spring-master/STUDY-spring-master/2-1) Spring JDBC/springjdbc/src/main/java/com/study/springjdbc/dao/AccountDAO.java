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

import com.study.springjdbc.vo.Account;

import static com.study.springjdbc.dao.DAOSqls.*;
@Component
public class AccountDAO {
  private NamedParameterJdbcTemplate jdbcTemplate;
  private SimpleJdbcInsert insert;

  public AccountDAO(DataSource dataSource) {
    jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    insert = new SimpleJdbcInsert(dataSource).withTableName("Account").usingColumns("balance")
        .usingGeneratedKeyColumns("id");
  }

  public Integer insert(Account noun) {
    SqlParameterSource params = new BeanPropertySqlParameterSource(noun);
    return insert.executeAndReturnKey(params).intValue();
  }

  public List<Account> selectAll() {
    return jdbcTemplate.query(ACCOUNT_SELECT_ALL, Collections.EMPTY_MAP,
        BeanPropertyRowMapper.newInstance(Account.class));
  }

  public List<Account> selectById(Integer id) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("id", id);
    return jdbcTemplate.query(ACCOUNT_SELECT_BY_ID, params,
        BeanPropertyRowMapper.newInstance(Account.class));
  }

  public Integer update(Account account) {
    SqlParameterSource params = new BeanPropertySqlParameterSource(account);
    return jdbcTemplate.update(ACCOUNT_UPDATE_BY_ID, params);
  }

  public Integer deleteById(Integer id) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("id", id);
    return jdbcTemplate.update(ACCOUNT_DELETE_BY_ID, params);
  }
}