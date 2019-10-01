package zoo;

public class Mammal extends Animal {

  // fields
  private boolean hasFur;

  // constructors
  public Mammal(String name) {
    super(name);
    this.hasFur = true;
  }

  // methods
  // overrides
  @Override
  public String breed() {
    return "pushing miniature versions out.";
  }

  @Override
  public void makeNoise() {
    System.out.println("mammm");
  }
}
