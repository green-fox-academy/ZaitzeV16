package animal;

public class Main {

  public static void main(String[] args) {
    /*
    Create an Animal class
      Every animal has a hunger value, which is a whole number
      Every animal has a thirst value, which is a whole number
      when creating a new animal object these values are created with the default 50 value
      Every animal can eat() which decreases their hunger by one
      Every animal can drink() which decreases their thirst by one
      Every animal can play() which increases both by one
     */

    Animal animal = new Animal();
    System.out.println("hunger: " + animal.hunger);
    System.out.println("thirst: " + animal.thirst);
    System.out.println();

    animal.eat();
    System.out.println("hunger: " + animal.hunger);
    System.out.println("thirst: " + animal.thirst);
    System.out.println();

    animal.drink();
    System.out.println("hunger: " + animal.hunger);
    System.out.println("thirst: " + animal.thirst);
    System.out.println();

    animal.play();
    System.out.println("hunger: " + animal.hunger);
    System.out.println("thirst: " + animal.thirst);
  }
}
