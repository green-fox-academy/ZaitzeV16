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

  // region Fields
  private FoxService foxService;
  // endregion Fields


  // region Constructors
  @Autowired
  public MainController(FoxService foxService) {
    this.foxService = foxService;
  }
  // endregion Constructors


  // region Endpoints
  //   region GETMappings
  @GetMapping(value = {"/", "/login"})
  public String doLogin() {
    return "login";
  }

  @GetMapping(value = "/register")
  public String register() {
    return "register";
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
  //   endregion GETMappings


  //   region POSTMappings
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

  @PostMapping(value = "/register")
  public String register(
      @RequestParam(name = "pet_name") String petName,
      RedirectAttributes rA) {
    rA.addFlashAttribute("newFox", this.foxService.addAndGetFox(petName));
    return "redirect:/information";
  }
  //   endregion POSTMappings
  // endregion Endpoints
}
