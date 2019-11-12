package com.greenfox.backend_api.controllers;

import com.greenfox.backend_api.models.dtos.ArrayHandlerRequestDTO;
import com.greenfox.backend_api.models.dtos.ResultDTO;
import com.greenfox.backend_api.models.dtos.LogEntryResultDTO;
import com.greenfox.backend_api.services.ApiServiceImpl;
import com.greenfox.backend_api.services.LogEntryServiceImpl;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {


  // region Fields
  private ApiServiceImpl apiService;
  private LogEntryServiceImpl logEntryService;
//  private ReverserOfTheSithServiceImpl sithService;
  // endregion Fields


  // region Constructors
  @Autowired
  public MyRestController(
      ApiServiceImpl apiService,
      LogEntryServiceImpl logEntryService
//      ReverserOfTheSithServiceImpl sithService
  ) {
    this.apiService = apiService;
    this.logEntryService = logEntryService;
//    this.sithService = sithService;
  }
  // endregion Constructors


  // region GetMappings
  @GetMapping(value = "/doubling")
  public HashMap<String, Object> doubling(
      @RequestParam(name = "input", required = false) Integer input) {
    // save log
    this.logEntryService.save("/doubling", "input=" + input);

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
    // save log
    this.logEntryService.save("/greeter", "name=" + name + " title=" + title);

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
    this.logEntryService.save("/appenda", "appendable=" + appendable);

    HashMap<String, Object> result = new HashMap<>();

    if (appendable == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    } else {
      result.put("appended", appendable + "a");
      return ResponseEntity.status(HttpStatus.OK).body(result);
    }
  }

  @GetMapping(value = "/log")
  public ResponseEntity<LogEntryResultDTO> log() {
    return this.logEntryService.getLogEntriesWithCount();
  }
  // endregion GetMappings


  // region PostMappings
  @PostMapping(value = "/dountil/{action}")
  public ResponseEntity doUntil(
      @PathVariable(name = "action", required = false) String action,
      @RequestBody(required = false) Map<String, ?> input) {
    this.logEntryService.save("/dountil",
        "action=" + action + " " + input.toString());

    HashMap<String, Object> result = new HashMap<>();

    if (action == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    } else if (input == null || !input.containsKey("until")) {
      result.put("error", "Please provide a number!");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    } else {

      if ("factor".equals(action)) {
        int num = Integer.parseInt(String.valueOf(input.get("until")));
        result.put("result", this.apiService.factorioRecursive(num));
        return ResponseEntity.status(HttpStatus.OK).body(result);

      } else if ("sum".equals(action)) {
        int num = Integer.parseInt(String.valueOf(input.get("until")));
        result.put("result", this.apiService.sumRecursive(num));
        return ResponseEntity.status(HttpStatus.OK).body(result);
      }
    }
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  @PostMapping(value = "/arrays")
  public ResponseEntity<ResultDTO> arrays(
      @RequestBody(required = false) ArrayHandlerRequestDTO input) {
    this.logEntryService.save("/arrays", input.toString());

    return this.apiService.arrays(input);
  }

//  @PostMapping(value = "/sith")
//  public ResponseEntity<ReverserOfTheSithResultDTO> sith(
//      @RequestBody(required = false) ReverserOfTheSithDTO input) {
//    this.logEntryService.save("/arrays", input.toString());
//
//    return this.sithService.getYodaMsg(input);
//  }
  // endregion PostMappings

}
