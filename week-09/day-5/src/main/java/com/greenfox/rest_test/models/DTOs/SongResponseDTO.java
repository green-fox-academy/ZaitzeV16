package com.greenfox.rest_test.models.DTOs;


import com.greenfox.rest_test.models.entities.Song;

public class SongResponseDTO implements ResponseDTO {

  // region Fields
  private long id;
  private String author;
  private String title;
  private String genre;
  private int year;
  private double rating;
  // endregion Fields


  // region Constructors
  public SongResponseDTO() {
  }

  public SongResponseDTO(String author, String title, String genre, int year, double rating) {
    this.author = author;
    this.title = title;
    this.genre = genre;
    this.year = year;
    this.rating = rating;
  }

  public SongResponseDTO(Song song) {
    this.id = song.getId();
    this.author = song.getAuthor();
    this.title =  song.getTitle();
    this.genre =  song.getGenre();
    this.year =   song.getYear();
    this.rating = song.getRating();
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
