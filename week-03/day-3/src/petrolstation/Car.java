package petrolstation;

public class Car {
  /*
  Create Station and Car classes
  Station
        gasAmount
        refill(car) -> decreases the gasAmount by the capacity of
        the car and increases the cars gasAmount
  Car
      gasAmount
      capacity
      create constructor for Car where:
          initialize gasAmount -> 0
          initialize capacity -> 100
   */

  int gasAmount;
  int capacity;

  // constructors
  public Car() {
    this(50, 50);
  }

  public Car(int gasAmount, int capacity) {
    this.gasAmount = gasAmount;
    this.capacity = capacity;
  }
}
