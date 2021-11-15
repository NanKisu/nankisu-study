package com.study.spring.test;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.study.spring.config.DispatcherServletContextConfig;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DispatcherServletContextConfig.class})
@WebAppConfiguration
public class MessageServiceTestMVC {
  @Autowired
  private WebApplicationContext webAppContext;
  
  private MockMvc mockMVC;
  
  @Before
  public void setupMockMVC() {
    this.mockMVC = MockMvcBuilders.webAppContextSetup(webAppContext).build();
  }
  
  @Test
  public void testHome() throws Exception {
    mockMVC.perform(get("/")).andExpect(status().isOk()).andExpect(forwardedUrl("/home.jsp"));
  }
  
  @Test
  public void testHomeWithParams() throws Exception {
    mockMVC.perform(get("/").param("param", "hello")).andExpect(status().isOk()).andExpect(forwardedUrl("/home.jsp"));
  }
  
  @Test
  public void testHomeAssert() throws Exception {
    mockMVC.perform(get("/").param("param", "hello")).andExpect(status().isOk()).andExpect(forwardedUrl("/home.jsp")).andExpect(view().name("home"));
  }
  
  @Test
  public void testHomeDo() throws Exception {
    mockMVC.perform(get("/").param("param", "hello")).andDo(log());
  }
}
