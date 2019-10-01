package flyable;

public class Helicopter extends Vehicle implements Flyable {
  // fields


  // constructors
  public Helicopter() {
    super();
  }

  public Helicopter(int fuel, double maxSpeed, int maxPassengers) {
    super(fuel, maxSpeed, maxPassengers);
  }


  // methods
  // overrides
  @Override
  public void land() {
    System.out.println("Chopper landing...");
  }

  @Override
  public void fly() {
    System.out.println("Fly copter...");
  }

  @Override
  public void takeOff() {
    System.out.println("Chopper taking off...");
  }

  @Override
  public void startEngine() {
    System.out.println("Starting rotors...");
  }
}
