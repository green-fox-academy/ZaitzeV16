package com.greenfox.programmer_fox_club.services;

import com.greenfox.programmer_fox_club.models.Drink;
import com.greenfox.programmer_fox_club.repositories.DrinkRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkServiceImpl implements DrinkService {

  // region Fields
  private DrinkRepository drinkRepository;
  // endregion Fields


  // region Constructors
  public DrinkServiceImpl() {
  }

  @Autowired
  public DrinkServiceImpl(DrinkRepository drinkRepository) {
    this.drinkRepository = drinkRepository;
  }
  // endregion Constructors


  // region FindBy
  @Override
  public Drink findById(long id) {
    return this.drinkRepository.findById(id).orElse(null);
  }

  @Override
  public Drink findByName(String petName) {
    return this.drinkRepository.findByName(petName);
  }
  // endregion FindBy


  // region FindAllBy
  @Override
  public List<Drink> findAllBy() {
    List<Drink> drinkList = new ArrayList<>();
    this.drinkRepository.findAll().forEach(drinkList::add);
    return drinkList;
  }
  // endregion FindAllBy


  // region SaveUpdate
  @Override
  public void save(Drink drink) {
    this.drinkRepository.save(drink);
  }
  // endregion SaveUpdate

}
