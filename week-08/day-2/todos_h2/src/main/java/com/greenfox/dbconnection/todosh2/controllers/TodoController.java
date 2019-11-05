package com.greenfox.dbconnection.todosh2.controllers;

import com.greenfox.dbconnection.todosh2.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/todo")
public class TodoController {

  // region Fields
  TodoRepository repository;
  // endregion Fields


  // region Constructors
  @Autowired
  public TodoController(TodoRepository repository) {
    this.repository = repository;
  }
  // endregion Constructors


  // region GetMappings
  @GetMapping(value = {"/", "/list"})
  @ResponseBody
  public String list() {
    return "This is my first Todo";
  }
  // endregion GetMappings

}
