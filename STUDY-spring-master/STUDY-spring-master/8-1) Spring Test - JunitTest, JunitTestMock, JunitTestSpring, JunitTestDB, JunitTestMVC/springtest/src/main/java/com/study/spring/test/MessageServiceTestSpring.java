package com.study.spring.test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
import java.util.Locale;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.study.spring.config.DispatcherServletContextConfig;
import com.study.spring.service.MessageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DispatcherServletContextConfig.class)
public class MessageServiceTestSpring {
  @Autowired
  MessageService messageService;  
  
  @Test
  public void testGetMessage() {
    MessageService messageService = new MessageService();
    String actualMessage = messageService.getMessage("greeting");
    assertThat(actualMessage, is("Hello World"));
  }
}
