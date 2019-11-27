package com.greenfox.rename.sb_template.controllers;

import com.greenfox.rename.sb_template.services.ChildOfUserServiceImpl;
import com.greenfox.rename.sb_template.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

  // region Fields
  private UserServiceImpl userService;
  private ChildOfUserServiceImpl childOfUserService;
  // endregion Fields


  // region Constructors
  @Autowired
  public MainController(UserServiceImpl userService, ChildOfUserServiceImpl childOfUserService) {
    this.userService = userService;
    this.childOfUserService = childOfUserService;
  }
  // endregion Constructors


  // region GetMappings
  // endregion GetMappings


  // region PostMappings
  // endregion PostMappings


  // region DeleteMappings
  // endregion DeleteMappings
}
