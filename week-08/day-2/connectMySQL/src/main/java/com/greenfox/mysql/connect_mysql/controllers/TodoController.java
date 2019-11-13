package com.greenfox.mysql.connect_mysql.controllers;

import com.greenfox.mysql.connect_mysql.models.Todo;
import com.greenfox.mysql.connect_mysql.services.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/todo")
public class TodoController {

  // region Fields
  private TodoServiceImpl todoService;
  // endregion Fields


  // region Constructors
  @Autowired
  public TodoController(
      TodoServiceImpl todoService) {
    this.todoService = todoService;
  }
  // endregion Constructors


  // region GetMappings
  @GetMapping(value = {"", "/", "/list"})
  public String todoList(Model model) {
    model.addAttribute("todos", todoService.findAll());
    return "todos";
  }

  @GetMapping(value = "/add")
  public String addTodo() {
    return "add_todo";
  }

  @GetMapping(value = "/{id}/delete")
  public String deleteTodo(@PathVariable long id) {
    this.todoService.deleteById(id);
    return "redirect:/todo/list";
  }

  @GetMapping(value = "/{id}/edit")
  public String showEditTodo(Model model, @PathVariable long id) {
    model.addAttribute("todo", this.todoService.findById(id));
    return "edit_todo";
  }
  // endregion GetMappings


  // region PostMappings
  @PostMapping(value = {"", "/", "/list"})
  public String filterListBy(
      Model model,
      @RequestParam(name = "is_done", required = false) boolean isDone,
      @RequestParam(name = "title", required = false) String title
  ) {
    if (title != null) {
      model.addAttribute("todos", todoService.filterByTitle(title));
    } else {
      model.addAttribute("todos", todoService.findAllByDone(isDone));
    }
    return "todos";
  }

  @PostMapping(value = "/add")
  public String addTodo(@RequestParam(name = "title") String todoTitle) {
    this.todoService.save(new Todo(todoTitle));
    return "redirect:/todo/list";
  }

  @PostMapping(value = "/{id}/edit")
  public String editTodo(
      @PathVariable long id,
      @ModelAttribute Todo todo) {
    this.todoService.update(id, todo.getTitle(), todo.getIsUrgent(), todo.getIsDone());
    return "redirect:/todo/list";
  }
  // endregion PostMappings
}
