package zoo;

public class Reptile extends Animal {

  // fields
  private boolean hasScales;

  // constructors
  public Reptile(String name) {
    super(name);
    this.hasScales = true;
  }

  // methods
  // getters and setters


  // overrides
  @Override
  public String breed() {
    return "laying eggs.";
  }

  @Override
  public void makeNoise() {
    System.out.println("growl");
  }
}
