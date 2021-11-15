package com.study.spring.test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.study.spring.config.DispatcherServletContextConfig;
import com.study.spring.service.MessageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DispatcherServletContextConfig.class)
@ActiveProfiles("dev")
@TestPropertySource(locations = "classpath:/test.properties")
public class MessageServiceTestSpring2 {
  @Autowired
  MessageService messageService;  
  
  @Value("${value}")
  String value;
  
  @Test
  @DirtiesContext
  public void testGetMessage() {
    MessageService messageService = new MessageService();
    String actualMessage = messageService.getMessage("greeting");
    assertThat(actualMessage, is("Hello World"));
  }
  
  @Test
  public void testPropertiesMessage() {
    assertThat(value, is("I did the work finally"));
  }
}
