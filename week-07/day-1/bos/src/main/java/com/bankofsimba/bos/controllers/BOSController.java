package com.bankofsimba.bos.controllers;

import com.bankofsimba.bos.models.BankAccount;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BOSController {

  private List<BankAccount> accounts;

  public BOSController() {
    this.accounts = new ArrayList<>();
    this.addBankAccount("Simba", 2000, "lion");
    this.addBankAccount("Mufasa", 99999, "lion");
    this.addBankAccount("Timon", 2000, "fat");
    this.addBankAccount("Aladdin", 0, "noob");
    this.addBankAccount("Shrek", 1, "green");
  }

  public void addBankAccount(String name, float balance, String animalType) {
    this.accounts.add(new BankAccount(name, balance, animalType));
  }

  @GetMapping(value = {"", "/"})
  public String showDefault() {
    return "index";
  }

  @GetMapping(value = "/simba")
  public String showSimba(Model model) {
    model.addAttribute(
        "accounts",
        this.accounts
            .stream()
            .filter(acc -> acc.getName().equals("Simba"))
            .collect(Collectors.toList()));
    return "show_simba";
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
