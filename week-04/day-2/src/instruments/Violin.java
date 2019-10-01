package instruments;

public class Violin extends StringedInstrument {

  // constructors
  public Violin() {
    this(4);
  }

  public Violin(int numberOfString) {
    super("Violin", numberOfString);
  }


  // methods
  // overrides
  @Override
  public String sound() {
    return "Screech";
  }
}
