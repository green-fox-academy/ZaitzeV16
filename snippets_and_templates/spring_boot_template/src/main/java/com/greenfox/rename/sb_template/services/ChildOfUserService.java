package com.greenfox.rename.sb_template.services;


import com.greenfox.rename.sb_template.models.entities.ChildOfUser;
import java.util.List;

public interface ChildOfUserService {

  public ChildOfUser save(ChildOfUser childOfUser);

  public ChildOfUser findById(long id);

  public List<ChildOfUser> findAll();
}
