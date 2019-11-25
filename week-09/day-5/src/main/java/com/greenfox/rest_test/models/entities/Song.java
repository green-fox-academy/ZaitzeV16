package com.greenfox.rest_test.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "songs")
public class Song {

  // region Fields
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String author;
  private String title;
  private String genre;
  private int year;
  private double rating;
  // endregion Fields


  // region Constructors
  public Song() {
  }

  public Song(String author, String title, String genre, int year, double rating) {
    this.author = author;
    this.title = title;
    this.genre = genre;
    this.year = year;
    this.rating = rating;
  }
  // endregion Constructors


  // region Getters
  public long getId() {
    return id;
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }

  public String getGenre() {
    return genre;
  }

  public int getYear() {
    return year;
  }

  public double getRating() {
    return rating;
  }
  // endregion Getters


  // region Setters
  public void setAuthor(String author) {
    this.author = author;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }
  // endregion Setters
}
