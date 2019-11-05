package com.greenfox.dbconnection.todosh2.controllers;

import com.greenfox.dbconnection.todosh2.models.Todo;
import com.greenfox.dbconnection.todosh2.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/todo")
public class TodoController implements CommandLineRunner {

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


  // region Methods
  //   region Overrides
  @Override
  public void run(String... args) throws Exception {
    this.todoRepository.save(new Todo("I have to learn Object Relational Mapping"));
    this.todoRepository.save(new Todo("And some more"));
    this.todoRepository.save(new Todo("write code"));
    this.todoRepository.save(new Todo("die silently"));
  }
  //   endregion Overrides
  // endregion Methods
}
