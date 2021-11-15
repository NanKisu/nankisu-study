package com.study.www.guestbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"com.study.www.guestbook.dao", "com.study.www.guestbook.service"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
