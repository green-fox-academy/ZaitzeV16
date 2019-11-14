package com.greenfox.programmer_fox_club.services;

import com.greenfox.programmer_fox_club.models.Fox;
import com.greenfox.programmer_fox_club.models.Trick;
import com.greenfox.programmer_fox_club.repositories.FoxRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoxServiceImpl implements FoxService {

  // region Fields
  private FoxRepository foxRepository;
  // endregion Fields


  // region Constructors
  public FoxServiceImpl() {
  }

  @Autowired
  public FoxServiceImpl(FoxRepository foxRepository) {
    this.foxRepository = foxRepository;
  }
  // endregion Constructors


  // region FindBy
  @Override
  public Fox findById(long id) {
    return this.foxRepository.findById(id).orElse(null);
  }

  @Override
  public Fox findByName(String petName) {
    return this.foxRepository.findByName(petName);
  }
  // endregion FindBy


  // region FindAllBy
  @Override
  public List<Fox> findAllBy() {
    List<Fox> foxList = new ArrayList<>();
    this.foxRepository.findAll().forEach(foxList::add);
    return foxList;
  }
  // endregion FindAllBy


  // region SaveUpdate
  @Override
  public void save(Fox fox) {
    this.foxRepository.save(fox);
  }

  @Override
  public void learnTrick(Fox fox, Trick trick) {
    fox.getTricks().add(trick);
    trick.getFoxes().add(fox);

    this.save(fox);
  }
  // endregion SaveUpdate

}
