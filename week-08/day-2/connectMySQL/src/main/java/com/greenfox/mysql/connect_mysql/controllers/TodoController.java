package com.greenfox.mysql.connect_mysql.controllers;

import com.greenfox.mysql.connect_mysql.models.Todo;
import com.greenfox.mysql.connect_mysql.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/todo")
public class TodoController implements CommandLineRunner {

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
  // endregion PostMappings


  // region Methods
  //   region Overrides
  @Override
  public void run(String... args) throws Exception {
//    this.todoService.save(new Todo("think of new tasks"));
//    this.todoService.save(new Todo("do something else"));
//    this.todoService.save(new Todo("watch Star Trek"));
//    this.todoService.save(new Todo("especially Discovery"));
//    this.todoService.save(new Todo("and more"));
//    this.todoService.save(new Todo("stand in the corner"));
//    this.todoService.save(new Todo("sajhlésadg"));
//    this.todoService.save(new Todo("could you read this"));
//    this.todoService.save(new Todo("asdasd"));
//    this.todoService.save(new Todo("ehh"));
//    this.todoService.save(new Todo("lie on the floor"));
//    this.todoService.save(new Todo("die on the loor"));

//    for (int i = 0; i < this.todoService.findAll().size(); i+=5) {
//      Todo currentTodo = this.todoService.findById(i);
//      if (currentTodo != null) {
//        currentTodo.setDone(true);
//        this.todoService.save(currentTodo);
//      }
//    }
  }
  //   endregion Overrides
  // endregion Methods
}
