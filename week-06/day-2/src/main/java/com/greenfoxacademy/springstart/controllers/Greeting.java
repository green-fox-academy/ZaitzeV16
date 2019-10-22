package com.greenfoxacademy.springstart.controllers;

public class Greeting {

  private long greetCount;
  private String content;

  public Greeting(long id, String content) {
    this.greetCount = id;
    this.content = content;
  }
}
