package com.greenfox.rename.sb_template.services;


import com.greenfox.rename.sb_template.models.entities.User;
import java.util.List;

public interface UserService {

  public User save(User user);

  public User findById(long id);

  public User findByUsername(String username);

  public List<User> findAll();
}
