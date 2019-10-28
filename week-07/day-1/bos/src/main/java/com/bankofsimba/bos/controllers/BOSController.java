package com.bankofsimba.bos.controllers;

import com.bankofsimba.bos.models.BankAccount;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BOSController {

  private List<BankAccount> accounts;

  public BOSController() {
    this.accounts = new ArrayList<>();
    this.addBankAccount("Simba", 2000, "lion");
  }

  public void addBankAccount(String name, float balance, String animalType) {
    this.accounts.add(new BankAccount(name, balance, animalType));
  }

  @GetMapping(value = {"", "/"})
  public String showDefault() {
    return "index";
  }

  @GetMapping(value = "/show")
  public String showAccounts(Model model) {
    model.addAttribute("accounts", this.accounts);
    return "show_accounts";
  }

  @GetMapping(value = "/htmlception")
  public String showHTMLCeption(Model model) {
    model.addAttribute("html1", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
    model.addAttribute("html2", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
    return "html_ception";
  }
}
