package com.greenfox.reddit.services;


import com.greenfox.reddit.models.User;

public interface UserService {

  public User findByUsername(String username);
}
