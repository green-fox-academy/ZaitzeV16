package com.web.shop.webshop.models;

import java.util.ArrayList;
import java.util.List;

public class ShopItemList {

  private List<ShopItem> itemList;

  public ShopItemList() {
    this.itemList = new ArrayList<>();
    this.populateItemList();
  }

  public List<ShopItem> getItemList() {
    return itemList;
  }

  private void populateItemList() {
    this.itemList.add(
        new ShopItem(
            "Running shoes",
            "Clothes and Shoes",
            "Nike running shoes for every day sport",
            1000.0,
            5)
    );
    this.itemList.add(
        new ShopItem(
            "Printer",
            "Electronics",
            "Some HP printer that will print pages",
            3000.0,
            2)
    );
    this.itemList.add(
        new ShopItem(
            "Coca cola",
            "Beverages and Snacks",
            "0.5l standard coke",
            25.0,
            0)
    );
    this.itemList.add(
        new ShopItem(
            "Wokin",
            "Beverages and Snacks",
            "Chicken with fried rice and WOKIN sauce",
            119.0,
            100)
    );
    this.itemList.add(
        new ShopItem(
            "T-shirt",
            "Clothes and Shoes",
            "Blue with corgi on a bike",
            300.0,
            1)
    );
  }

  public void addItem(ShopItem shopItem) {
    this.itemList.add(shopItem);
  }

}
