package com.greenfox.programmer_fox_club.repositories;


import com.greenfox.programmer_fox_club.models.Fox;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class FoxRepository {

  private List<Fox> foxes = new ArrayList<>();

  public FoxRepository() {
    // TODO: 2019. 11. 04. only for test purposes
    this.foxes.add(new Fox("Karak"));
    this.foxes.add(new Fox("Kajak"));
    this.foxes.add(new Fox("szemelygepjarmu"));
    this.foxes.add(new Fox("Bela"));
  }

  public List<Fox> getFoxes() {
    return foxes;
  }

  public void addFox(Fox fox) {
    this.foxes.add(fox);
  }

  public boolean existsFox(String petName) {
    return this.getFoxes()
        .stream()
        .anyMatch(f -> petName.equals(f.getName()));
  }

  public Fox getFox(String petName) {
    if (this.existsFox(petName)) {
      return this.getFoxes()
          .stream()
          .filter(f -> petName.equals(f.getName()))
          .collect(Collectors.toList())
          .get(0);
    }
    return null;
  }


}
