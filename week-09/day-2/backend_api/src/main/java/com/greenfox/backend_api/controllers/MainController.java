package com.greenfox.backend_api.controllers;

import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

  @GetMapping(value = "/greeter")
  public ResponseEntity greeter(
      @RequestParam(name = "name", required = false) String name,
      @RequestParam(name = "title", required = false) String title) {
    HashMap<String, Object> result = new HashMap<>();
    if (name == null && title == null) {
      result.put("error", "Please provide a name and a title!");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    } else if (name == null) {
      result.put("error", "Please provide a name!");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    } else if (title == null) {
      result.put("error", "Please provide a title!");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    } else {
      result.put("welcome_message", "Oh, hi there " + name + ", my dear "+ title + "!");
      return ResponseEntity.status(HttpStatus.OK).body(result);
    }
  }
  // endregion GetMappings
}
