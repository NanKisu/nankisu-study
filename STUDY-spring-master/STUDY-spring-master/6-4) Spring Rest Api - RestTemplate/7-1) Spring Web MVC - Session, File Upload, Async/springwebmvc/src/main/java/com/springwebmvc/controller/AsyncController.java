package com.springwebmvc.controller;

import java.io.IOException;
import java.util.UUID;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Controller
@RequestMapping(path = {"/async"})
public class AsyncController {  
  @GetMapping(path = {"/count"})
  public String count() throws InterruptedException {
    return countToTen();
  }
  
  @GetMapping(path = {"/sseemitter"})
  public SseEmitter sseEmitter() throws IOException, InterruptedException  {
    SseEmitter emitter = new SseEmitter();
    sendThreeTimes(emitter);
    return emitter;
  }
  
  @Async
  public String countToTen() throws InterruptedException {
    System.out.println(Thread.currentThread().getName() + " countToTen...");
    for(int i = 1; i <= 10; i++) {
      System.out.println(i);
      Thread.sleep(1000);
    }
    System.out.println(Thread.currentThread().getName() + " END...");
    return "home";
  }
  
  @Async
  public void sendThreeTimes(SseEmitter emitter) throws IOException, InterruptedException {
    emitter.send(emitter.event().id(UUID.randomUUID().toString()).data("Hello"));
    Thread.sleep(3000);
    emitter.send(emitter.event().id(UUID.randomUUID().toString()).data("World"));
    Thread.sleep(3000);
    emitter.complete();
  }

}
