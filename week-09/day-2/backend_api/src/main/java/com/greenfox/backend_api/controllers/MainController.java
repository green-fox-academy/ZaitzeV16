package com.greenfox.backend_api.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
      result.put("result", input * 2);
    }
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
      result.put("welcome_message", "Oh, hi there " + name + ", my dear " + title + "!");
      return ResponseEntity.status(HttpStatus.OK).body(result);
    }
  }

  @GetMapping(value = "/appenda/{appendable}")
  public ResponseEntity appendA(
      @PathVariable(name = "appendable", required = false) String appendable) {
    HashMap<String, Object> result = new HashMap<>();

    if (appendable == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    } else {
      result.put("appended", appendable + "a");
      return ResponseEntity.status(HttpStatus.OK).body(result);
    }
  }
  // endregion GetMappings


  // region PostMappings
  @PostMapping(value = "/dountil/{action}")
  public ResponseEntity doUntil(
      @PathVariable(name = "action", required = false) String action,
      @RequestBody(required = false) Map<String, ?> input) {

    HashMap<String, Object> result = new HashMap<>();

    if (action == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    } else if (input == null || !input.containsKey("until")) {
      result.put("error", "Please provide a number!");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    } else {

      if ("factor".equals(action)) {
        int num = Integer.parseInt(String.valueOf(input.get("until")));
        result.put("result", factorioRecursive(num));
        return ResponseEntity.status(HttpStatus.OK).body(result);

      } else if ("sum".equals(action)) {
        int num = Integer.parseInt(String.valueOf(input.get("until")));
        result.put("result", sumRecursive(num));
        return ResponseEntity.status(HttpStatus.OK).body(result);
      }
    }
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }
  // endregion PostMappings

  // region HelperFunction
  private static long factorioRecursive(int num) {
    if (num == 1) {
      return 1;
    } else {
      return num * (factorioRecursive(num - 1));
    }
  }

  private static int sumRecursive(int n) {
    if (n == 1) {
      return 1;
    } else {
      return sumRecursive(n - 1) + n;
    }
  }
  // endregion HelperFunction
}
