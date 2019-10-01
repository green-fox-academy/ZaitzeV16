package zoo;

public abstract class Animal {

  // private fields
  private String name;

  // constructors
  public Animal(String name) {
    this.name = name;
  }


  // getter and setters
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }


  // abstract methods
  public abstract String breed();

  public abstract void makeNoise();
}
