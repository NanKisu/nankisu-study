package com.study.spring.springjpa.config;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DBConfig {
  @Bean
  public DataSource dataSource() {
    EmbeddedDatabase dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).setScriptEncoding("UTF-8").addScript("MyUser.sql").build();
    return dataSource;
  }
}
