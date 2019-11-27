package com.greenfox.rename.sb_template.controllers;

import com.greenfox.rename.sb_template.services.ChildOfUserServiceImpl;
import com.greenfox.rename.sb_template.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RENAMERestController {


  // region Fields
  private UserServiceImpl userService;
  private ChildOfUserServiceImpl childOfUserService;
  // endregion Fields


  // region Constructors
  @Autowired
  public RENAMERestController(
      UserServiceImpl userService,
      ChildOfUserServiceImpl childOfUserService) {
    this.userService = userService;
    this.childOfUserService = childOfUserService;
  }
  // endregion Constructors


  // region GetMappings) {
  // endregion GetMappings


  // region PostMappings
  // endregion PostMappings

}
