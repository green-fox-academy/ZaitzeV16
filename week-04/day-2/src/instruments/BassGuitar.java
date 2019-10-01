package instruments;

public class BassGuitar extends StringedInstrument {

  // constructors
  public BassGuitar() {
    this(4);
  }

  public BassGuitar(int numberOfString) {
    super("Bass Guitar", numberOfString);
  }


  // methods
  // overrides
  @Override
  public String sound() {
    return "Duum-duum-duum";
  }
}
