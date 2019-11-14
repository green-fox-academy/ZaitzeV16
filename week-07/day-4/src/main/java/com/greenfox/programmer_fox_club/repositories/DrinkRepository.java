package com.greenfox.programmer_fox_club.repositories;


import com.greenfox.programmer_fox_club.models.Drink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends CrudRepository<Drink, Long> {

  // region FindBy
  public Drink findByName(String name);
  // endregion FindBy

  // region FindAllBy
  // endregion FindAllBy

  // region SaveUpdate
  // endregion SaveUpdate

  // region
  // endregion

}
