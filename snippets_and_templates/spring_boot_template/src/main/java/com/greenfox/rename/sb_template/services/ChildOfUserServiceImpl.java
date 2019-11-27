package com.greenfox.rename.sb_template.services;

import com.greenfox.rename.sb_template.models.entities.ChildOfUser;
import com.greenfox.rename.sb_template.repositories.ChildOfUserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildOfUserServiceImpl implements ChildOfUserService {

  // region Fields
  private ChildOfUserRepository repository;
  // endregion Fields


  // region Constructors
  @Autowired
  public ChildOfUserServiceImpl(ChildOfUserRepository repository) {
    this.repository = repository;
  }
  // endregion Constructors


  // region CRUD
  //   region CreateUpdate
  @Override
  public ChildOfUser save(ChildOfUser childOfUser) {
    return this.repository.save(childOfUser);
  }
  //   endregion CreateUpdate


  //   region Read
  @Override
  public ChildOfUser findById(long id) {
    return this.repository.findById(id).orElse(null);
  }

  @Override
  public List<ChildOfUser> findAll() {
    List<ChildOfUser> result = new ArrayList<>();
    this.repository.findAll().forEach(result::add);
    return result;
  }
  //   endregion Read

  //   region Delete
  //   endregion Delete
  // endregion CRUD
}
