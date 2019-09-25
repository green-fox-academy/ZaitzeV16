package petrolstation;

public class Main {

  public static void main(String[] args) {
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

    Car car = new Car(20, 100);
    Station station = new Station();

    System.out.println(car.capacity);
    System.out.println(car.gasAmount);
    System.out.println();
    System.out.println(station.gasAmount);
    System.out.println();

    station.refill(car);
    System.out.println(car.capacity);
    System.out.println(car.gasAmount);
    System.out.println();
    System.out.println(station.gasAmount);
    System.out.println();
  }
}
