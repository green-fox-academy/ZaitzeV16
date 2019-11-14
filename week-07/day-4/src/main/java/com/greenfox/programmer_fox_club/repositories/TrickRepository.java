package com.greenfox.programmer_fox_club.repositories;


import com.greenfox.programmer_fox_club.models.Trick;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrickRepository extends CrudRepository<Trick, Long> {

  // region FindBy
  public Trick findByName(String name);
  // endregion FindBy


  // region FindAllBy
  // endregion FindAllBy

  // region SaveUpdate
  // endregion SaveUpdate

  // region
  // endregion

}
