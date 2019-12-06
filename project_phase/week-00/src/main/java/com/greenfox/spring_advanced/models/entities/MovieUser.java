package com.greenfox.spring_advanced.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "movie_users")
public class MovieUser {

  // region Fields
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(length = 50)
  private String username;
  private String password;
  private String authority;
  private boolean enabled;
  // endregion Fields


  // region Constructors
  public MovieUser(String username, String password) {
    this.username = username;
    this.password = password;
    this.enabled = true;
    this.authority = "USER";
  }
  // endregion Constructors
}
