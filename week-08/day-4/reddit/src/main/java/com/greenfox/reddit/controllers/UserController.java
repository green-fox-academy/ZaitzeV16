package com.greenfox.reddit.controllers;

import com.greenfox.reddit.models.Post;
import com.greenfox.reddit.models.User;
import com.greenfox.reddit.services.UserServiceImpl;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Getter
@Setter
public class UserController {

  // region Fields
  private UserServiceImpl userService;
  // endregion Fields


  // region Constructors
  @Autowired
  public UserController(UserServiceImpl userService) {
    this.userService = userService;
  }
  // endregion Constructors


  // region CRUD
  //   region Create
  public User save(User user) {
    return this.userService.save(user);
  }

  public User save(String name) {
    return this.userService.save(new User(name));
  }
  //   endregion Create


  //   region Read
  public User findById(long id) {
    return this.userService.findById(id);
  }

  public User findByUsername(String username) {
    return this.userService.findByUsername(username);
  }

  public List<User> findAll() {
    return this.userService.findAll();
  }
  //   endregion Read


  //   region Update
  public User save(User user, Post newPost) {
    List<Post> newPosts = user.getPosts();
    newPosts.add(newPost);
    user.setPosts(newPosts);
    return this.userService.save(user);
  }
  //   endregion Update
  // endregion CRUD
}
