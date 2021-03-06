package com.greenfox.programmer_fox_club.repositories;


import com.greenfox.programmer_fox_club.models.Fox;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoxRepository extends CrudRepository<Fox, Long> {

  // region FindBy
  public Fox findByName(String name);
  // endregion FindBy

  // region FindAllBy
  // endregion FindAllBy

  // region SaveUpdate
  // endregion SaveUpdate

  // region
  // endregion

}
