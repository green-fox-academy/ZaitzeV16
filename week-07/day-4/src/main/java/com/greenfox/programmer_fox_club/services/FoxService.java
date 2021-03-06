package com.greenfox.programmer_fox_club.services;

import com.greenfox.programmer_fox_club.models.Fox;
import com.greenfox.programmer_fox_club.models.Trick;
import java.util.List;

public interface FoxService {

  // region FindBy
  public Fox findById(long id);

  public Fox findByName(String name);
  // endregion FindBy


  // region FindAllBy
  public List<Fox> findAllBy();
  // endregion FindAllBy


  // region SaveUpdate
  public void save(Fox fox);

  public void learnTrick(Fox fox, Trick trick);
  // endregion SaveUpdate

}
