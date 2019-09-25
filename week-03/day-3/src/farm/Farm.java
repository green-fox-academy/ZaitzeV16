package farm;

import java.util.ArrayList;

public class Farm {
  /*
  #### Farm
  - Reuse your `Animal` class
  - Create a `Farm` class
    - it has list of Animals
    - it has slots which defines the number of free places for animals
    - breed() -> creates a new animal if there's place for it
    - slaughter() -> removes the least hungry animal
   */

  ArrayList<Animal> animals = new ArrayList<>();
  int freeSlots;

  // constructors
  public Farm() {
    this(1, 0);
  }

  public Farm(int numberOfAnimals) {
    this(numberOfAnimals, 0);
  }

  public Farm(int numberOfAnimals, int freeSlots) {
    for (int i = 0; i < numberOfAnimals; i++) {
      this.animals.add(new Animal());
    }
    this.freeSlots = freeSlots;
  }

  // functions
  public void breed() {
    if (this.freeSlots > 0) {
      this.animals.add(new Animal());
      this.freeSlots--;
    }
  }

  public void slaughter() {
    this.animals.remove(this.getLeastHungryIndex());
    this.freeSlots++;
  }

  // private functions
  public int getLeastHungryIndex() {
    int hunger = -1;
    int animalIndex = -1;

    for (int i = 0; i < this.animals.size(); i++) {
      if (hunger == -1 || this.animals.get(i).hunger < hunger) {
        hunger = this.animals.get(i).hunger;
        animalIndex = i;
      }
    }
    return animalIndex;
  }


}
