package instruments;

public class ElectricGuitar extends StringedInstrument {

  // constructors
  public ElectricGuitar() {
    this(6);
  }

  public ElectricGuitar(int numberOfString) {
    super("Electric Guitar", numberOfString);
  }


  // methods
  // overrides
  @Override
  public String sound() {
    return "Twang";
  }
}
