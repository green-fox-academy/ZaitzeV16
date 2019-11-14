package com.greenfox.programmer_fox_club.controllers;

import com.greenfox.programmer_fox_club.services.FoxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

  // region Fields
  private FoxServiceImpl foxServiceImpl;
  // endregion Fields


  // region Constructors
  @Autowired
  public MainController(FoxServiceImpl foxServiceImpl) {
    this.foxServiceImpl = foxServiceImpl;
  }
  // endregion Constructors


  // region GETMappings
  @GetMapping(value = "/information")
  @ModelAttribute
  public ModelAndView showInformation(ModelAndView modelAndView) {
    modelAndView.setViewName("information");
    modelAndView.addObject("fox", this.foxServiceImpl.findById(1));
    modelAndView.addObject("tricks", this.foxServiceImpl.findById(1).getTricks());
    return modelAndView;
  }

  @GetMapping(value = "/register")
  public String register() {
    return "register";
  }
  // endregion GETMappings

  // region POSTMappings
//  @PostMapping(value = "/register")
//  public String register(@ModelAttribute(name = "fox")Fox fox,
//      @RequestParam(name = "pet_name") String petName,
//      RedirectAttributes rA) {
//    rA.addFlashAttribute("newFox", this.foxServiceImpl.addAndGetFox(petName));
//    return "redirect:/information";
//  }
  // endregion POSTMappings
}
