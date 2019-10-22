package com.greenfoxacademy.springstart.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

  @RequestMapping(value = "/web/fizzBuzzWoof")
  public String fizzBuzzWoof(Model model) {
    String[] data = decideFizzBuzzWoof((int) greetCount.incrementAndGet());
    String msg = data[0];
    int counter = Integer.parseInt(data[1]);

    model.addAttribute("counter", counter);
    model.addAttribute("msg", msg);
    return "fizzBuzzWoof";
  }

  private String[] decideFizzBuzzWoof(int num) {
    boolean div3 = (num % 3 == 0);
    boolean div5 = (num % 5 == 0);
    boolean div7 = (num % 7 == 0);
    List<String> resultString = new ArrayList<>();
    int counter = 0;

    if (div3) {
      resultString.add("Fizz");
      counter++;
    }
    if (div5) {
      resultString.add("Buzz");
      counter++;
    }
    if (div7) {
      resultString.add("Woof");
      counter++;
    }

    if (resultString.isEmpty()) {
      resultString.add(String.valueOf(num));
    }

    return new String[]{String.join("", resultString), String.valueOf(counter)};
  }
}
