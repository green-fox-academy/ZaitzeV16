package com.greenfox.programmer_fox_club.services;

import com.greenfox.programmer_fox_club.models.Drink;
import com.greenfox.programmer_fox_club.models.Food;
import com.greenfox.programmer_fox_club.models.Fox;
import com.greenfox.programmer_fox_club.models.Trick;
import com.greenfox.programmer_fox_club.repositories.FoxRepository;
import com.greenfox.programmer_fox_club.repositories.NutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoxService {

  // region Fields
  private NutritionRepository nutritionRepository;
  private FoxRepository foxRepository;
  // endregion Fields


  // region Constructors
  @Autowired
  public FoxService(NutritionRepository nutritionRepository, FoxRepository foxRepository) {
    this.foxRepository = foxRepository;
    this.nutritionRepository = nutritionRepository;
    this.addStarterFoxesAndNutritions();
  }
  // endregion Constructors

  // TODO: 2019. 11. 04. add some Foxes and nutritions
  private void addStarterFoxesAndNutritions() {
    this.nutritionRepository.addFood("kajak");
    this.nutritionRepository.addFood("gyalog");
    this.nutritionRepository.addFood("METÁL");
    this.nutritionRepository.addFood("béla");

    this.nutritionRepository.addDrink("wasser genyó");
    this.nutritionRepository.addDrink("mitMIVAN");
    this.nutritionRepository.addDrink("MÖTÁL");
    this.nutritionRepository.addDrink("pici");


    this.nutritionRepository.setDefaultFood(this.getFoodByName("béla"));
    this.nutritionRepository.setDefaultDrink(this.getDrinkByName("pici"));

    this.addFox("Karak");
    this.addFox("Kajak");
    this.addFox("szemelygepjarmu");
    this.addFox("Bela");

    Fox fox = this.getFoxByName("szemelygepjarmu");
    fox.learnTrick(new Trick("visíts kutya!"));
    fox.learnTrick(new Trick("nyugodjááá meg"));
    fox.learnTrick(new Trick("vau vau maderfaker"));
  }

  // region Getters
  public Fox getFoxByName(String petName) {
    return this.foxRepository.getFoxByName(petName);
  }

  public Food getFoodByName(String foodName) {
    return this.nutritionRepository.getFoodByName(foodName);
  }

  public Drink getDrinkByName(String drinkName) {
    return this.nutritionRepository.getDrinkByName(drinkName);
  }
  // endregion Getters

  // region Setters
  // endregion Setters


  // region Methods
  //   region Public
  public void addFox(String petName) {
    Fox newFox = this.foxRepository.addFox(petName);
    newFox.setFood(this.nutritionRepository.getDefaultFood());
    newFox.setDrink(this.nutritionRepository.getDefaultDrink());
  }

  public Fox addAndGetFox(String petName) {
    this.addFox(petName);
    return this.foxRepository.getFoxByName(petName);
  }

  public boolean existsFox(String petName) {
    return this.foxRepository.existsFox(petName);
  }
  //   endregion Public
  // endregion Methods
}
