package com.study.spring.test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.study.spring.config.DispatcherServletContextConfig;
import com.study.spring.service.MessageService;


public class MessageServiceTestBasic {
  @Test
  public void testGetMessage() {
    MessageService messageService = new MessageService();
    String actualMessage = messageService.getMessage("greeting");
    assertThat(actualMessage, is("Hello World"));
  }
}
