package zoo;

import flyable.Flyable;

public class Bird extends Animal implements Flyable {

  // fields
  private boolean hasFathers;
  private boolean hasWings;

  // constructors

  public Bird(String name) {
    super(name);
    this.hasFathers = true;
    this.hasWings = true;
  }

  // methods
  //getters and setter


  // overrides
  @Override
  public String breed() {
    return "laying eggs.";
  }

  @Override
  public void makeNoise() {
    System.out.println("chirp-chirp");
  }

  @Override
  public void land() {
    System.out.println("Bird is landing...");
  }

  @Override
  public void fly() {
    System.out.println("Bird is flying...");
  }

  @Override
  public void takeOff() {
    System.out.println("Bird is taking off...");
  }
}
