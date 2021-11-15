package com.study.spring.test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
import static org.mockito.Mockito.*;
import java.util.Locale;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.study.spring.config.DispatcherServletContextConfig;
import com.study.spring.service.MessageService;

@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTestMock {
  @InjectMocks
  MessageService messageService;
  
  @Mock
  MessageSource messageSource;
  
  
  @Test
  public void testGetMessage() {
    doReturn(messageSource).when(messageSource).getMessage("greeting", null, Locale.getDefault());
    MessageService messageService = new MessageService();
    String actualMessage = messageService.getMessage("greeting");
    assertThat(actualMessage, is("Hello World"));
  }
}
