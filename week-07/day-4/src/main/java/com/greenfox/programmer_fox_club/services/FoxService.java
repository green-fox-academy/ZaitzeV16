package com.greenfox.programmer_fox_club.services;

import com.greenfox.programmer_fox_club.models.Fox;
import com.greenfox.programmer_fox_club.repositories.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoxService {

  private FoxRepository repository;

  @Autowired
  public FoxService(FoxRepository repository) {
    this.repository = repository;
  }

  public FoxRepository getRepository() {
    return repository;
  }

  public Fox getFox(String petName) {
    return this.repository.getFox(petName);
  }
}
