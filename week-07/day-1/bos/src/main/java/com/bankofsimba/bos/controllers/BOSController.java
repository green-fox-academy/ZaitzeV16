package com.bankofsimba.bos.controllers;

import com.bankofsimba.bos.models.BankAccount;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
  @ResponseBody
  public String showHTMLCeption() {
    return "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>";
  }
}
