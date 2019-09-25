package farm;

public class Animal {

  /*
  #### Farm
  - Reuse your `Animal` class
  - Create a `Farm` class
    - it has list of Animals
    - it has slots which defines the number of free places for animals
    - breed() -> creates a new animal if there's place for it
    - slaughter() -> removes the least hungry animal
   */

  int hunger;
  int thirst;

  Animal() {
    this.hunger = 50;
    this.thirst = 50;
  }

  public void eat() {
    this.hunger--;
  }

  public void drink() {
    this.thirst--;
  }

  public void play() {
    this.hunger++;
    this.thirst++;
  }
}
