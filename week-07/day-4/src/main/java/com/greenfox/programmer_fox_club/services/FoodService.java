package com.greenfox.programmer_fox_club.services;

import com.greenfox.programmer_fox_club.models.Food;
import java.util.List;

public interface FoodService {

  // region FindBy
  public Food findById(long id);

  public Food findByName(String name);
  // endregion FindBy


  // region FindAllBy
  public List<Food> findAllBy();
  // endregion FindAllBy


  // region SaveUpdate
  public void save(Food food);
  // endregion SaveUpdate

}
