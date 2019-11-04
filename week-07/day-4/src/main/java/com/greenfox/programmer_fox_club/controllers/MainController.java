package com.greenfox.programmer_fox_club.controllers;

import com.greenfox.programmer_fox_club.models.Fox;
import com.greenfox.programmer_fox_club.services.FoxService;
import java.util.Objects;
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
  public String doLogin(
      @RequestParam(name = "pet_name") String petName,
      RedirectAttributes rA) {
    if (!this.foxService.existsFox(petName)) {
      return "redirect:/login";
    }
    rA.addFlashAttribute("petName", petName);
    return "redirect:/information";
  }

  @GetMapping(value = "/register")
  public String register() {
    return "register";
  }

  @PostMapping(value = "/register")
  public String register(
      @RequestParam(name = "pet_name") String petName,
      RedirectAttributes rA) {
    rA.addFlashAttribute("newFox", this.foxService.addAndGetFox(petName));
    return "redirect:/information";
  }

  @GetMapping(value = "/information")
  @ModelAttribute
  public String showInformation(Model model) {
    Fox fox = (model.containsAttribute("newFox")) ?
        (Fox) (model.getAttribute("newFox")) : null;
    String petName = (String) model.getAttribute("petName");

    Fox newFox = (fox == null) ? (
        (!petName.trim().isEmpty()) ? this.foxService.addAndGetFox(petName) : null
    ) : fox;
    if (newFox == null) {
      return "redirect:/login";
    }
    model.addAttribute("fox", newFox);
    return "information";
  }

//  @GetMapping(value = "/information")
//  @ModelAttribute(name = "fox")
//  public String showInformation(
//      Model model,
//      @ModelAttribute(name = "petName") String petName) {
////    Fox fox = (optionalFox.length == 1) ? optionalFox[0] : null;
//    Fox fox = (model.getAttribute("fox").length == 1) ? optionalFox[0] : null;
//    Fox newFox = (fox == null) ? (
//        (!petName.trim().isEmpty()) ? this.foxService.addAndGetFox(petName) : null
//        ) : fox;
//    if (newFox == null) {
//      return "redirect:/login";
//    }
//    model.addAttribute("fox", newFox);
//    return "information";
//  }


}
