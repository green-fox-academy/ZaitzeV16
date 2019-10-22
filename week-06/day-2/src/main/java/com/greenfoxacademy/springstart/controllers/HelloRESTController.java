package com.greenfoxacademy.springstart.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRESTController {

//  @GetMapping
  @RequestMapping(value = "/greeting")
  public static Greeting greeting() {
    return new Greeting(10, "Das ist ein content");
  }
}
