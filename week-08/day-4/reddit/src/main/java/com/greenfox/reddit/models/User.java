package com.greenfox.reddit.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

  // region Fields
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(length = 50)
  private String username;
  private String password;
  private String authority;
  private boolean enabled;
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "created_by_id")
  private List<Post> posts = new ArrayList<>();
  // endregion Fields


  // region Constructors
  public User(String username) {
    this.username = username;
    this.enabled = true;
    this.authority = "USER";
  }
  // endregion Constructors
}
