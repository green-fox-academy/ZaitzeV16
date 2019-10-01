package flyable;

import zoo.Bird;

public class Main {

  public static void main(String[] args) {
    Helicopter helicopter = new Helicopter();
    helicopter.fly();
    helicopter.land();
    helicopter.startEngine();
    helicopter.takeOff();

    Bird bird = new Bird("some Bird");
    bird.fly();
    bird.land();
    bird.takeOff();
  }
}
