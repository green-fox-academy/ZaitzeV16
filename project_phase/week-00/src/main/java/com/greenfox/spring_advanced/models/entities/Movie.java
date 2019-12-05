package com.greenfox.spring_advanced.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "movies")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

  // region Fields
  @Id
  private long id;

  private double popularity;
  private long vote_count;
  private boolean video;
  private String poster_path;
  private boolean adult;
  private String backdrop_path;
  private String original_language;
  private String original_title;
  private String title;
  private double vote_average;

  @Column(length = 3000)
  private String overview;

  private Date release_date;
  // endregion Fields


  // region Setters
  public void setRelease_date(String release_date) throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    this.release_date = dateFormat.parse(release_date);
  }
  // endregion Setters
}
