package com.study.spring.test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
import org.junit.*;
import com.study.spring.service.MessageService;

public class MessageServiceTest {
  @Test
  public void testGetMessage() {
    MessageService service = new MessageService();
    String actualMessage = service.getMessage();
    assertThat(actualMessage, is("Hello World"));
  }
}
