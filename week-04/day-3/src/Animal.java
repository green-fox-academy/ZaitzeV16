public class Animal {

  // fields
  private int hunger;
  private int thirst;


  // constructors
  Animal() {
    this.hunger = 50;
    this.thirst = 50;
  }


  // getters and setters
  public int getHunger() {
    return hunger;
  }

  public void setHunger(int hunger) {
    this.hunger = hunger;
  }

  public int getThirst() {
    return thirst;
  }

  public void setThirst(int thirst) {
    this.thirst = thirst;
  }

  // methods
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
