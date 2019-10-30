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

  @GetMapping(value = {"/useful/caesar/encode"})
  public String showCaesarEncoded(Model model,
      @RequestParam(name = "number") String number,
      @RequestParam(name = "text") String text) {
    // multiple params: /useful/caesar/encode?text=yourtext&number=2
    model.addAttribute("text", text);
    model.addAttribute("parsedText",
        this.utilityService.caesar(text, Integer.parseInt(number)));
    return "useful_caesar";
  }

  @GetMapping(value = {"/useful/caesar/decode"})
  public String showCaesarDecoded(Model model,
      @RequestParam(name = "number") String number,
      @RequestParam(name = "text") String text) {
    // multiple params: /useful/caesar/encode?text=yourtext&number=2
    model.addAttribute("text", text);
    model.addAttribute("parsedText",
        this.utilityService.caesar(text, -1 * Integer.parseInt(number)));
    return "useful_caesar";
  }
}
