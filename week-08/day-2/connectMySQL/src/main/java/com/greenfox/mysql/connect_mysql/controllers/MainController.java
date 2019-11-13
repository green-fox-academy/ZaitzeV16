package com.greenfox.mysql.connect_mysql.controllers;

import com.greenfox.mysql.connect_mysql.models.Assignee;
import com.greenfox.mysql.connect_mysql.models.Todo;
import com.greenfox.mysql.connect_mysql.services.AssigneeServiceImpl;
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
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/todo")
public class MainController {

  // region Fields
  private TodoServiceImpl todoService;
  private AssigneeServiceImpl assigneeService;
  // endregion Fields


  // region Constructors
  @Autowired
  public MainController(
      TodoServiceImpl todoService,
      AssigneeServiceImpl assigneeService) {
    this.todoService = todoService;
    this.assigneeService = assigneeService;
  }
  // endregion Constructors


  // region GetMappings
  //   region todo related
  @GetMapping(value = {"", "/", "/list"})
  public String todoList(Model model) {
    model.addAttribute("todos", todoService.findAll());
    return "todos";
  }

  @GetMapping(value = "/add")
  public String addTodo(
      Model model,
      @ModelAttribute(name = "todo") Todo todo) {
    model.addAttribute("assignees", this.assigneeService.findAll());
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
    model.addAttribute("assignees", this.assigneeService.findAll());
    return "edit_todo";
  }
  //   endregion todo related


  //   region Assignee related
  @GetMapping(value = {"/assignees", "/assignees/", "/assignees/list"})
  public ModelAndView assigneeList(ModelAndView modelAndView) {
    modelAndView.addObject("assignees", this.assigneeService.findAll());
    modelAndView.setViewName("/assignees");
    return modelAndView;
  }

  @GetMapping(value = "/assignees/add")
  public String addAssignee() {
    return "add_assignee";
  }

  @GetMapping(value = "/assignees/{id}/delete")
  public String deleteAssignee(@PathVariable long id) {
    this.assigneeService.deleteById(id);
    return "redirect:/todo/assignees/list";
  }

  @GetMapping(value = "/assignees/{id}/edit")
  public String editAssignee(Model model, @PathVariable long id) {
    model.addAttribute("assignee", this.assigneeService.findById(id));
    return "edit_assignee";
  }

  @GetMapping(value = "/assignees/{id}/todos")
  public String getTodosForAssignee(Model model, @PathVariable long id) {
    model.addAttribute("todos", this.assigneeService.findById(id).getTodos());
    return "todos";
  }
  //   endregion Assignee related
  // endregion GetMappings


  // region PostMappings
  //   region todo related
  @PostMapping(value = {"", "/", "/list"})
  public String filterListBy(
      Model model,
      @RequestParam(name = "is_done", required = false) boolean isDone,
      @RequestParam(name = "title", required = false) String title
  ) {
    if (title != null) {
      model.addAttribute("todos", this.todoService.findAllByTitleOrAssigneeName(title));
    } else {
      model.addAttribute("todos", todoService.findAllByDone(isDone));
    }
    return "todos";
  }

  @PostMapping(value = "/add")
  public String addTodo(@ModelAttribute(name = "todo") Todo todo) {
    System.out.println(todo.getDueDate());
    System.out.println(todo.getDueDate().getClass());
    this.assigneeService.save(
        this.assigneeService.findById(todo.getAssignee().getId()),
        new Todo(
            todo.getTitle(),
            todo.getIsUrgent(),
            todo.getIsDone(),
            todo.getDueDate())
    );
    return "redirect:/todo/list";
  }

  @PostMapping(value = "/{id}/edit")
  public String editTodo(
      @PathVariable long id,
      @ModelAttribute Todo todo) {
    this.todoService.update(
        id,
        todo.getTitle(),
        todo.getIsUrgent(),
        todo.getIsDone(),
        todo.getDueDate(),
        todo.getAssignee());
    return "redirect:/todo/list";
  }
  //   endregion todo related


  //   region Assignee related
  @PostMapping(value = "/assignees/add")
  public String addTodo(
      @RequestParam(name = "name") String name,
      @RequestParam(name = "email") String email) {
    this.assigneeService.save(new Assignee(name, email));
    return "redirect:/todo/assignees/list";
  }

  @PostMapping(value = "/assignees/{id}/edit")
  public String editAssignee(
      @PathVariable long id,
      @ModelAttribute Assignee assignee) {
    this.assigneeService.update(id, assignee.getName(), assignee.getEmail());
    return "redirect:/todo/assignees/list";
  }
  //   endregion Assignee related
  // endregion PostMappings
}
