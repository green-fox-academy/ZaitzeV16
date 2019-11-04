package com.greenfox.programmer_fox_club.repositories;


import com.greenfox.programmer_fox_club.models.Fox;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class FoxRepository {

  // region Fields
  private List<Fox> foxes = new ArrayList<>();
  // endregion Fields


  // region Constructors
  public FoxRepository() {
  }
  // endregion Constructors


  // region Getters
  public List<Fox> getFoxes() {
    return this.foxes;
  }

  public Fox getFoxByName(String petName) {
    if (this.existsFox(petName)) {
      return this.getFoxes()
          .stream()
          .filter(f -> petName.equals(f.getName()))
          .collect(Collectors.toList())
          .get(0);
    }
    return null;
  }
  // endregion Getters


  // region Setters
  // endregion Setters


  // region Methods
  //   region Public
  public Fox addFox(String petName) {
    Fox newFox = new Fox(petName);
    this.foxes.add(newFox);
    return newFox;
  }

  public boolean existsFox(String petName) {
    return this.getFoxes()
        .stream()
        .anyMatch(f -> petName.toLowerCase().equals(f.getName().toLowerCase()));
  }
  //   endregion Public
  // endregion Methods
}
