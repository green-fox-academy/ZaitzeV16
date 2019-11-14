package com.greenfox.programmer_fox_club.services;

import com.greenfox.programmer_fox_club.models.Drink;
import java.util.List;

public interface DrinkService {

  // region FindBy
  public Drink findById(long id);

  public Drink findByName(String name);
  // endregion FindBy


  // region FindAllBy
  public List<Drink> findAllBy();
  // endregion FindAllBy


  // region SaveUpdate
  public void save(Drink drink);
  // endregion SaveUpdate

}
