package com.dependency_injection.di.controllers;

import com.dependency_injection.di.services.UtilityService;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

  @GetMapping(value = {"/useful/email"})
  public String showUsefulEmail(Model model, @RequestParam(name = "email") String email) {
    HashMap<String, String> data = this.utilityService.validateEmail(email);
    model.addAttribute("msg", data.get("msg"));
    model.addAttribute("color", data.get("color"));
    return "useful_email";
  }
}
