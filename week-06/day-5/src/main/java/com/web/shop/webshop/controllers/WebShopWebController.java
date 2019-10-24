package com.web.shop.webshop.controllers;

import com.web.shop.webshop.models.ShopItemList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebShopWebController {
  private ShopItemList items = new ShopItemList();

  @RequestMapping(value = "/")
  public String getIndex(Model model) {
    model.addAttribute("items", this.items.getItemList());
    return "index";
  }
}
