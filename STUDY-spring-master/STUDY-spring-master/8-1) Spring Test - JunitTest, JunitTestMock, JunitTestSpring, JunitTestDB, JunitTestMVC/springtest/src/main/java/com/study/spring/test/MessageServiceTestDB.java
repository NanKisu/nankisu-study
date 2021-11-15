package com.study.spring.test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.study.spring.config.DBConfig;
import com.study.spring.dao.Noun001DAO;
import com.study.springj.vo.Noun001;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DBConfig.class)
public class MessageServiceTestDB{
  @Autowired
  Noun001DAO noun001DAO;
  
//  @Test
//  @Transactional
//  @DirtiesContext
//  public void testCreate() {
//    Noun001 noun = new Noun001();
//    noun.setSysC("000");
//    noun.setValue("empty");
//    Integer id = noun001DAO.insert(noun);
//    assertThat(id, is(1));
//  }
  
  @Test
  @Transactional
  @Sql("/insert.sql")
  @Commit
  //@Rollback
  public void testCreate() {
  }
  
  @Test
  public void testSelect() {
    Noun001 noun = noun001DAO.selectById(1).get(0);
    assertThat(noun.getId(), is(1));
    assertThat(noun.getSysC(), is("000"));
    assertThat(noun.getValue(), is("empty"));
  }
  
//  @Test
//  @Sql("/insert.sql")
//  public void testSelectWithSql() {
//    Noun001 noun = noun001DAO.selectById(1).get(0);
//    assertThat(noun.getId(), is(1));
//    assertThat(noun.getSysC(), is("000"));
//    assertThat(noun.getValue(), is("empty"));
//  }
}