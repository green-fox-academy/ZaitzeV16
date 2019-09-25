package animal;

public class Animal {

  /*
  Create an Animal class
    Every animal has a hunger value, which is a whole number
    Every animal has a thirst value, which is a whole number
    when creating a new animal object these values are created with the default 50 value
    Every animal can eat() which decreases their hunger by one
    Every animal can drink() which decreases their thirst by one
    Every animal can play() which increases both by one
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
