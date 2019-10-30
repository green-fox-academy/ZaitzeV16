package com.dependency_injection.di.controllers;

import com.dependency_injection.di.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  private UtilityService utilityService;

  @Autowired
  public MainController(UtilityService utilityService) {
    this.utilityService = utilityService;
  }

  @GetMapping(value = {"/", "/useful"})
  public String showUsefulLinks() {
    return "useful";
  }

  @GetMapping(value = {"/useful/colored"})
  public String showUsefulColored(Model model) {
    model.addAttribute("bgColor", this.utilityService.randomColor());
    return "useful_colored";
  }
}
