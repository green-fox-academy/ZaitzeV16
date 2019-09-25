package petrolstation;

public class Station {
  /*
  Create Station and Car classes
  Station
        gasAmount
        // not quite
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

  // constructors
  public Station() {
    this(1000);
  }

  public Station(int gasAmount) {
    this.gasAmount = gasAmount;
  }

  // functions
  public void refill(Car car) {
    this.gasAmount -= car.capacity - car.gasAmount;
    car.gasAmount += car.capacity - car.gasAmount;
  }
}
