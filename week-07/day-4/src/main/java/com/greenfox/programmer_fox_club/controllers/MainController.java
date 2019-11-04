package com.greenfox.programmer_fox_club.controllers;

import com.greenfox.programmer_fox_club.models.Fox;
import com.greenfox.programmer_fox_club.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

  private FoxService foxService;

  @Autowired
  public MainController(FoxService foxService) {
    this.foxService = foxService;
  }

  @GetMapping(value = {"/", "/login"})
  public String doLogin() {
    return "login";
  }

  @PostMapping(value = "/login")
  public String doLogin(@RequestParam(name = "pet_name") String petName, RedirectAttributes rA) {

    rA.addFlashAttribute("petName", petName);
    return "redirect:/information";
  }

  @GetMapping(value = "/information")
  public String showInformation(@ModelAttribute(name = "petName") String petName, Model model) {
    Fox fox = this.foxService.getFox(petName);
    if (fox == null) {
      return "redirect:/login";
    }

    model.addAttribute("fox", fox);
    return "information";
  }


}
