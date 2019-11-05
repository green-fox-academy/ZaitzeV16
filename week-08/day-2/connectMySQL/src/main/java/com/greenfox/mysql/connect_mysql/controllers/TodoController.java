package com.greenfox.mysql.connect_mysql.controllers;

import com.greenfox.mysql.connect_mysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/todo")
public class TodoController {

  // region Fields
  private TodoRepository todoRepository;
  // endregion Fields


  // region Constructors
  @Autowired
  public TodoController(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }
  // endregion Constructors


  // region GetMappings
  @GetMapping(value = {"/", "/list"})
  public String list(Model model) {
    model.addAttribute("todos", todoRepository.findAll());
    return "todos";
  }
  // endregion GetMappings
}
