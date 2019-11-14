package com.greenfox.programmer_fox_club.services;

import com.greenfox.programmer_fox_club.models.Trick;
import com.greenfox.programmer_fox_club.repositories.TrickRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrickServiceImpl implements TrickService {

  // region Fields
  private TrickRepository trickRepository;
  // endregion Fields


  // region Constructors
  public TrickServiceImpl() {
  }

  @Autowired
  public TrickServiceImpl(TrickRepository trickRepository) {
    this.trickRepository = trickRepository;
  }
  // endregion Constructors


  // region FindBy
  @Override
  public Trick findById(long id) {
    return this.trickRepository.findById(id).orElse(null);
  }

  @Override
  public Trick findByName(String petName) {
    return this.trickRepository.findByName(petName);
  }
  // endregion FindBy


  // region FindAllBy
  @Override
  public List<Trick> findAllBy() {
    List<Trick> trickList = new ArrayList<>();
    this.trickRepository.findAll().forEach(trickList::add);
    return trickList;
  }
  // endregion FindAllBy


  // region SaveUpdate
  @Override
  public void save(Trick trick) {
    this.trickRepository.save(trick);
  }
  // endregion SaveUpdate

}
