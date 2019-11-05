package com.greenfox.mysql.connect_mysql.controllers;

import com.greenfox.mysql.connect_mysql.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/todo")
public class TodoController {

  // region Fields
  private TodoService todoService;
  // endregion Fields


  // region Constructors
  @Autowired
  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }
  // endregion Constructors


  // region GetMappings
  @GetMapping(value = {"", "/", "/list"})
  public String list(Model model) {
    model.addAttribute("todos", todoService.findAll());
    return "todos";
  }

  @GetMapping(value = "/add")
  public String addTodo() {
    return "add";
  }

  @GetMapping(value = "/{id}/delete")
  public String deleteTodo(@PathVariable long id) {
    this.todoService.deleteById(id);
    return "redirect:/todo/list";
  }

  @GetMapping(value = "/{id}/edit")
  public String showEditTodo(
      Model model,
      @PathVariable long id) {
    model.addAttribute("todo", this.todoService.findById(id));
    return "edit";
  }
  // endregion GetMappings


  // region PostMappings
  @PostMapping(value = {"", "/", "/list"})
  public String filterUndoneList(
      Model model,
      @RequestParam(name = "undone") boolean isUndone
  ) {
    model.addAttribute("todos", todoService.findAllByIsDone(isUndone));
    return "todos";
  }

  @PostMapping(value = "/add")
  public String addTodo(@RequestParam(name = "title") String todoTitle) {
    this.todoService.save(todoTitle);
    return "redirect:/todo/list";
  }

  @PostMapping(value = "/{id}/edit")
  public String editTodo(
      @PathVariable long id,
      @RequestParam(name = "title") String title,
      @RequestParam(name = "isUrgent") boolean urgent,
      @RequestParam(name = "isDone") boolean done) {
    this.todoService.update(id, title, urgent, done);
    return "redirect:/todo/list";
  }
  // endregion PostMappings
}
