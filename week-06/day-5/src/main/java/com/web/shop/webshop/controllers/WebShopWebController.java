package com.web.shop.webshop.controllers;

import com.web.shop.webshop.models.ShopItem;
import com.web.shop.webshop.models.ShopItemList;
import java.util.Comparator;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebShopWebController {

  private ShopItemList items = new ShopItemList();

  // FILTERING
  @PostMapping(value = "/")
  public String filterByPrice(
      @RequestParam String action,
      @RequestParam String pattern,
      Model model) {
    if (pattern.isEmpty() ||
        !pattern.chars()
            .allMatch(Character::isDigit)) {
      model.addAttribute("items", this.items.getItemList());
      return "index";
    }

    int priceValue = Integer.parseInt(pattern);
    model.addAttribute(
        "items",
        this.items.getItemList()
            .stream()
            .filter(shopItem ->
                ("above".equals(action)) ? shopItem.getPrice() > priceValue :
                    (("below".equals(action)) ? shopItem.getPrice() < priceValue :
                        shopItem.getPrice() == priceValue))
            .collect(Collectors.toList()));
    return "index";
  }

  @GetMapping(value = "/only-available")
  public String filterByAvailability(Model model) {
    model.addAttribute(
        "items",
        this.items.getItemList()
            .stream()
            .filter(shopItem -> shopItem.getQuantityOfStock() > 0)
            .collect(Collectors.toList()));
    return "index";
  }

  @GetMapping(value = "/contains-nike")
  public String filterContainsNike(Model model) {
    model.addAttribute(
        "items",
        this.items.getItemList()
            .stream()
            .filter(shopItem -> shopItem.getName().toLowerCase().contains("nike") ||
                shopItem.getDescription().toLowerCase().contains("nike"))
            .collect(Collectors.toList()));
    return "index";
  }

  @GetMapping(value = "/clothes-and-shoes")
  public String filterClothesAndShoes(Model model) {
    model.addAttribute(
        "items",
        this.items.getItemList()
            .stream()
            .filter(shopItem ->
                shopItem.getType().toLowerCase().contains("Clothes and Shoes".toLowerCase()))
            .collect(Collectors.toList()));
    return "index";
  }

  @GetMapping(value = "/electronics")
  public String filterElectonics(Model model) {
    model.addAttribute(
        "items",
        this.items.getItemList()
            .stream()
            .filter(
                shopItem -> shopItem.getType().toLowerCase().contains("Electronics".toLowerCase()))
            .collect(Collectors.toList()));
    return "index";
  }

  @GetMapping(value = "/beverages-and-snacks")
  public String filterBeveragesAndSnacks(Model model) {
    model.addAttribute(
        "items",
        this.items.getItemList()
            .stream()
            .filter(shopItem -> shopItem.getType().toLowerCase()
                .contains("Beverages and Snacks".toLowerCase()))
            .collect(Collectors.toList()));
    return "index";
  }

  // ORDERING
  @GetMapping(value = "/cheapest-first")
  public String orderCheapestFirst(Model model) {
    model.addAttribute(
        "items",
        this.items.getItemList()
            .stream()
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList()));
    return "index";
  }

  // ETC
  @GetMapping(value = "/")
  public String getIndex(Model model) {
    model.addAttribute("items", this.items.getItemList());
    return "index";
  }

  @GetMapping(value = "/average-stock")
  public String getAverageStock(Model model) {
    model.addAttribute(
        "average_stock",
        this.items.getItemList()
            .stream()
            .map(ShopItem::getQuantityOfStock)
            .mapToDouble(num -> (double) num)
            .average()
            .orElse(-1));
    return "average_stock";
  }

  @GetMapping(value = "/most-expensive")
  public String getMostExpensive(Model model) {
    model.addAttribute(
        "items",
        this.items.getItemList()
            .stream()
            .sorted(Comparator.reverseOrder())
            .limit(1)
            .collect(Collectors.toList()));
    return "index";
  }
}
