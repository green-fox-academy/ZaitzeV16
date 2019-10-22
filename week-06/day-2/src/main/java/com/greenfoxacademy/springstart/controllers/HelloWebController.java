package com.greenfoxacademy.springstart.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

@Controller
public class HelloWebController {

  private static AtomicLong greetCount = new AtomicLong(0);
  private static HashMap<String, String> hellosByLang = new HashMap<String, String>() {{
    put("au", "Grüß Gott");
    put("eng", "Hi");
    put("chn", "Nǐ hǎo");
    put("fin", "hyvää päivää");
    put("de", "Guten tag");
    put("hun", "Jó napot");
    put("it", "Salve");
    put("jpn", "Konnichiwa");
    put("ru", "Zdravstvuyte");
  }};

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

  @RequestMapping(value = "/web/greetByLang")
  public String countGreetByLang(Model model, @RequestParam String lang) {
    String hello;
    hello = StringUtils.capitalize(hellosByLang.get(lang.toLowerCase()));

    model.addAttribute("hello", hello);
    model.addAttribute("count", String.valueOf((int) greetCount.incrementAndGet()));
    return "greetingByLang";
  }
}