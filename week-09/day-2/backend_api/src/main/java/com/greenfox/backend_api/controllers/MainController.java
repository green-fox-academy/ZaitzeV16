package com.greenfox.backend_api.controllers;

import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

  // region GetMappings
  @GetMapping(value = "/")
  public ModelAndView index() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("index");
    return modelAndView;
  }

  @GetMapping(value = "/doubling")
  public HashMap<String, Object> doubling(
      @RequestParam(name = "input", required = false) Integer input) {
    HashMap<String, Object> result = new HashMap<>();
    if (input == null) {
      result.put("error", "Please provide an input!");
    } else {
      result.put("received", input);
      result.put("result", input * 2);    }
    return result;
  }
  // endregion GetMappings
}
