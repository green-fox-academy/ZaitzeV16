package com.greenfox.spring_advanced.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authorities")
public class MovieUserGrantedAuthority implements GrantedAuthority {

  // region Fields
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String authority;
  // endregion Fields


  // region Getters
  public long getId() {
    return id;
  }

  @Override
  public String getAuthority() {
    return this.authority;
  }
  // endregion Getters
}
