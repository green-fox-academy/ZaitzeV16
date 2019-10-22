package com.greenfoxacademy.springstart.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRESTController {
  private static AtomicLong greetCount = new AtomicLong(0);

  @RequestMapping(value = "/greeting")
  public static Greeting greeting(@RequestParam String name) {
    return new Greeting(greetCount.incrementAndGet(), "Das ist ein content for " + name);
  }
}
