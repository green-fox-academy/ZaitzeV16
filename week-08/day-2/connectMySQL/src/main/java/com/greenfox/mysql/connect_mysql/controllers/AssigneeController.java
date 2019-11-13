package com.greenfox.mysql.connect_mysql.controllers;

import com.greenfox.mysql.connect_mysql.models.Assignee;
import com.greenfox.mysql.connect_mysql.services.AssigneeServiceImpl;
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
@RequestMapping(value = "/todo/assignees")
public class AssigneeController {

  // region Fields
  private AssigneeServiceImpl assigneeService;
  // endregion Fields


  // region Constructors
  @Autowired
  public AssigneeController(
      AssigneeServiceImpl assigneeService) {
    this.assigneeService = assigneeService;
  }
  // endregion Constructors


  // region GetMappings
  @GetMapping(value = {"", "/", "/list"})
  public ModelAndView assigneeList(ModelAndView modelAndView) {
    modelAndView.addObject("assignees", this.assigneeService.findAll());
    modelAndView.setViewName("/assignees");
    return modelAndView;
  }

  @GetMapping(value = "/add")
  public String addAssignee() {
    return "add_assignee";
  }

  @GetMapping(value = "/{id}/delete")
  public String deleteAssignee(@PathVariable long id) {
    this.assigneeService.deleteById(id);
    return "redirect:/todo/assignees/list";
  }

  @GetMapping(value = "/{id}/edit")
  public String editAssignee(Model model, @PathVariable long id) {
    model.addAttribute("assignee", this.assigneeService.findById(id));
    return "edit_assignee";
  }
  // endregion GetMappings


  // region PostMappings
  @PostMapping(value = "/add")
  public String addTodo(
      @RequestParam(name = "name") String name,
      @RequestParam(name = "email") String email) {
    this.assigneeService.save(new Assignee(name, email));
    return "redirect:/todo/assignees/list";
  }
//  @PostMapping(value = {"", "/", "/list"})
//  public String filterListBy(
//      Model model,
//      @RequestParam(name = "is_done", required = false) boolean isDone,
//      @RequestParam(name = "title", required = false) String title
//  ) {
//    if (title != null) {
//      model.addAttribute("todos", todoService.filterByTitle(title));
//    } else {
//      model.addAttribute("todos", todoService.findAllByDone(isDone));
//    }
//    return "todos";
//  }
//

//
  @PostMapping(value = "/{id}/edit")
  public String editAssignee(
      @PathVariable long id,
      @ModelAttribute Assignee assignee) {
    this.assigneeService.update(id, assignee.getName(), assignee.getEmail());
    return "redirect:/todo/assignees/list";
  }
  // endregion PostMappings
}
