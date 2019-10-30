package com.dependency_injection.gfapp.controllers;

import com.dependency_injection.gfapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  private StudentService studentService;

  @Autowired
  public MainController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping(value = {"/", "/gfa"})
  public String showGreenFox() {
    return "gfa_index";
  }

  @GetMapping(value = "/gfa/list")
  public String showGreenFoxStudents(Model model) {
    model.addAttribute("studentList", this.studentService.findAll());
    return "gfa_student_list";
  }

  @GetMapping(value = "/gfa/add")
  public String addStudent() {
    return "gfa_student_add";
  }

  @PostMapping(value = "/gfa/save")
  public String saveStudent(@RequestParam(name = "name") String student_name) {
    this.studentService.save(student_name);
    return "redirect:/gfa/list";
  }
}
