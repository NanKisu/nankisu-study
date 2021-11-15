package com.study.webapp.rest.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;
import com.study.webapp.rest.dto.BookInfo;
import com.study.webapp.rest.dto.SearchBookInfoCondition;

@Repository
public class BookInfoDao {
	private NamedParameterJdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert jdbcInsert;

	public BookInfoDao(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("BookInfo").usingColumns("name", "publishedDate")
				.usingGeneratedKeyColumns("bookId");
	}

	public Integer createBookInfo(BookInfo bookInfo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(bookInfo);
		return jdbcInsert.executeAndReturnKey(params).intValue();
	}

	public List<BookInfo> readBookInfoById(Integer bookId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bookId", bookId);
		return jdbcTemplate.query("SELECT * FROM BookInfo WHERE bookId = :bookId", params,
				BeanPropertyRowMapper.newInstance(BookInfo.class));
	}

	public List<BookInfo> readBookInfoByCondition(SearchBookInfoCondition condition) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(condition);
		return jdbcTemplate.query(
				"SELECT * FROM BookInfo WHERE (:bookId is null OR bookId = :bookId) AND (:name is null OR name = :name) AND (:publishedDate is null OR publishedDate = :publishedDate)",
				params, BeanPropertyRowMapper.newInstance(BookInfo.class));
	}

	public Integer updateBookInfo(BookInfo bookInfo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(bookInfo);
		return jdbcTemplate.update(
				"UPDATE BookInfo SET name = :name, publishedDate = :publishedDate WHERE bookId = :bookId",
				new BeanPropertySqlParameterSource(bookInfo));
	}

	public Integer deleteBookInfoById(Integer bookId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bookId", bookId);
		return jdbcTemplate.update("DELETE FROM BookInfo WHERE bookId = :bookId", params);
	}
}
