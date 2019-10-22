package com.greenfoxacademy.springstart.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWebController {
  private static AtomicLong greetCount = new AtomicLong(0);

  @RequestMapping(value = "/web/greeting")
  public String greeting(Model model) {
    model.addAttribute("name", " World");
    return "greeting";
  }

  @RequestMapping(value = "/web")
  public String countAndGreetWithName(Model model, @RequestParam String name) {
    model.addAttribute("name", name);
    model.addAttribute("count", String.valueOf((int) greetCount.incrementAndGet()));
    return "greetingCount";
  }
}
