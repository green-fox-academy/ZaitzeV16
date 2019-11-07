package com.greenfox.reddit.services;

import com.greenfox.reddit.models.User;
import com.greenfox.reddit.repositories.UserRepository;
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
  //   region Create
  public User save(User user) {
    return this.repository.save(user);
  }

  public User save(String name) {
    return this.repository.save(new User(name));
  }
  //   endregion Create


  //   region Read
  public User findById(long id) {
    return this.repository.findById(id).orElse(null);
  }

  public User findByUsername(String username) {
    return this.repository.findByUsername(username);
  }

  public List<User> findAll() {
    List<User> users = new ArrayList<>();
    this.repository.findAll().forEach(users::add);
    return users;
  }
  //   endregion Read
  // endregion CRUD
}
