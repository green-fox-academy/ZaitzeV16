package zoo;

public class Bird extends Animal {

  // fields
  private boolean hasFathers;
  private boolean hasWings;

  // constructors

  public Bird(String name) {
    super(name);
    this.hasFathers = true;
    this.hasWings = true;
  }

  // methods
  //getters and setter


  // overrides
  @Override
  public String breed() {
    return "laying eggs.";
  }

  @Override
  public void makeNoise() {
    System.out.println("chirp-chirp");
  }
}
