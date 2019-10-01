package flyable;

public abstract class Vehicle {
  // fields
  private int fuel;
  private double maxSpeed;
  private int maxPassengers;


  // constructors
  public Vehicle() {
    this(50, 100, 1);
  }

  public Vehicle(int fuel, double maxSpeed, int maxPassengers) {
    this.fuel = fuel;
    this.maxSpeed = maxSpeed;
    this.maxPassengers = maxPassengers;
  }

  // getters and setters
  public int getFuel() {
    return fuel;
  }

  public void setFuel(int fuel) {
    this.fuel = fuel;
  }

  public double getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(double maxSpeed) {
    this.maxSpeed = maxSpeed;
  }

  public int getMaxPassengers() {
    return maxPassengers;
  }

  public void setMaxPassengers(int maxPassengers) {
    this.maxPassengers = maxPassengers;
  }

  // methods
  // abstract methods
  public abstract void startEngine();
}
