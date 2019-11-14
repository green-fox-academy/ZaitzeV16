package com.greenfox.programmer_fox_club.services;

import com.greenfox.programmer_fox_club.models.Trick;
import java.util.List;

public interface TrickService {

  // region FindBy
  public Trick findById(long id);

  public Trick findByName(String name);
  // endregion FindBy


  // region FindAllBy
  public List<Trick> findAllBy();
  // endregion FindAllBy


  // region SaveUpdate
  public void save(Trick trick);
  // endregion SaveUpdate

}
