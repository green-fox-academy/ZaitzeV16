package com.greenfox.rename.sb_template.services;

import com.greenfox.rename.sb_template.models.entities.ChildOfUser;
import com.greenfox.rename.sb_template.models.entities.User;
import com.greenfox.rename.sb_template.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  // region Fields
  private UserRepository repository;
  // endregion Fields


  // region Constructors
  @Autowired
  public UserServiceImpl(UserRepository repository) {
    this.repository = repository;
  }
  // endregion Constructors


  // region CRUD
  //   region CreateUpdate
  @Override
  public User save(User user) {
    return this.repository.save(user);
  }

  public User save(User user, ChildOfUser childOfUser) {
    List<ChildOfUser> children = user.getChildren();
    children.add(childOfUser);
    user.setChildren(children);
    return this.save(user);
  }
  //   endregion CreateUpdate


  //   region Read
  @Override
  public User findById(long id) {
    return this.repository.findById(id).orElse(null);
  }

  @Override
  public User findByUsername(String username) {
    return this.repository.findByUsername(username);
  }

  @Override
  public List<User> findAll() {
    List<User> users = new ArrayList<>();
    this.repository.findAll().forEach(users::add);
    return users;
  }
  //   endregion Read
  // endregion CRUD
}
