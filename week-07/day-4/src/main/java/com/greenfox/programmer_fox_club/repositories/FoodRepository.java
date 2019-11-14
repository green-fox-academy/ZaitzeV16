package com.greenfox.programmer_fox_club.repositories;


import com.greenfox.programmer_fox_club.models.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {

  // region FindBy
  public Food findByName(String name);
  // endregion FindBy

  // region FindAllBy
  // endregion FindAllBy

  // region SaveUpdate
  // endregion SaveUpdate

  // region
  // endregion

}
