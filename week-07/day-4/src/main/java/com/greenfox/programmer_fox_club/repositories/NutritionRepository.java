package com.greenfox.programmer_fox_club.repositories;


import com.greenfox.programmer_fox_club.models.Drink;
import com.greenfox.programmer_fox_club.models.Food;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class NutritionRepository {

  // region Fields
  private List<Food> foods;
  private List<Drink> drinks;

  private Food defaultFood;
  private Drink defaultDrink;
  // endregion Fields


  // region Constructors
  public NutritionRepository() {
    this.foods = new ArrayList<>();
    this.drinks = new ArrayList<>();
  }
  // endregion Constructors


  // region Getters
  public List<Food> getFoods() {
    return this.foods;
  }

  public List<Drink> getDrinks() {
    return drinks;
  }

  public Food getDefaultFood() {
    return defaultFood;
  }

  public Drink getDefaultDrink() {
    return defaultDrink;
  }

  public Food getFoodByName(String foodName) {
    return this.foods
        .stream()
        .filter(food -> foodName.equals(food.getName()))
        .findAny()
        .orElse(null);
  }

  public Drink getDrinkByName(String drinkName) {
    return this.drinks
        .stream()
        .filter(drink -> drinkName.equals(drink.getName()))
        .findAny()
        .orElse(null);
  }
  // endregion Getters


  // region Setters
  public void setDefaultFood(Food defaultFood) {
    this.defaultFood = defaultFood;
  }

  public void setDefaultDrink(Drink defaultDrink) {
    this.defaultDrink = defaultDrink;
  }
  // endregion Setters


  // region Methods
  //   region Public
  public void addFood(String foodName) {
    this.foods.add(new Food(foodName));
  }

  public void addFood(Food food) {
    this.foods.add(food);
  }

  public void addDrink(String drinkName) {
    this.drinks.add(new Drink(drinkName));
  }

  public void addDrink(Drink drink) {
    this.drinks.add(drink);
  }

  public boolean existsDrink(String drinkName) {
    return this.drinks
        .stream()
        .anyMatch(d -> drinkName.toLowerCase().equals(d.getName().toLowerCase()));
  }

  public boolean existsFood(String foodName) {
    return this.drinks
        .stream()
        .anyMatch(f -> foodName.toLowerCase().equals(f.getName().toLowerCase()));
  }
  //   endregion Public
  // endregion Methods
}
