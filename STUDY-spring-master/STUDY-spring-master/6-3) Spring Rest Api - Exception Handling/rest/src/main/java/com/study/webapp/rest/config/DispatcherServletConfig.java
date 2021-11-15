package com.study.webapp.rest.config;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.study.webapp.rest.controller", "com.study.webapp.rest.dao"})
public class DispatcherServletConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    // TODO Auto-generated method stub
    super.addCorsMappings(registry);
    registry.addMapping("/bookInfo");
    registry.addMapping("/bookInfo/*");
  }
  
  
  
  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    // TODO Auto-generated method stub
    super.configureMessageConverters(converters);
    MappingJackson2HttpMessageConverter jacksonMessageConverter = new MappingJackson2HttpMessageConverter();
    ObjectMapper objectMapper = jacksonMessageConverter.getObjectMapper();

    objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    objectMapper.setDateFormat(new StdDateFormat());

    converters.add(jacksonMessageConverter);
  }



  @Bean
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
        .addScript("classpath:/h2.sql").build();
  }
}
