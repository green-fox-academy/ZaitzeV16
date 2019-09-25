package pirates;

public class Parrot {

  Pirate owner;
  String name;

  // constructor
  public Parrot(String name, Pirate owner) {
    this.name = name;
    this.owner = owner;
  }

  // function
  public void talk() {
    System.out.println("Gyurrrrika wants cookie!!");
  }
}
