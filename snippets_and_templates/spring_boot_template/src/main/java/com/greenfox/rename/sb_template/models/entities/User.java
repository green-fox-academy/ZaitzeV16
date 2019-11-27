package com.greenfox.rename.sb_template.models.entities;

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

@Entity
@Table(name = "users")
@Getter
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
  private List<ChildOfUser> children = new ArrayList<>();
  // endregion Fields


  // region Constructors
  public User() {
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
    this.enabled = true;
    this.authority = "USER";
  }
  // endregion Constructors


  // region Setters
  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public void setChildren(List<ChildOfUser> children) {
    this.children = children;
  }
  // endregion Setters
}
