package com.greenfox.dbconnection.todosh2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Todo {

  // region Fields
  private long id;
  private String title;
  private boolean urgent = false;
  private boolean done = false;
  // endregion Fields




}
