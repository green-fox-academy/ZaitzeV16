package instruments;

public abstract class StringedInstrument extends Instrument {
  /*
  Next, we add another abstract class, `StringedInstrument` which *extends*
  `Instrument`. It

  - introduces `numberOfStrings` and
  - `sound()` method what's implementation is yet unknown
  - but with the help of the `sound()` the `play()` method is fully implementable
   */

  // fields
  private int numberOfStrings;


  // constructors
  public StringedInstrument(int numberOfStrings) {
    this("instrument", numberOfStrings);
  }

  public StringedInstrument(String name, int numberOfStrings) {
    super(name);
    this.numberOfStrings = numberOfStrings;
  }

  // getters and setters


  // methods
  // overrides
  @Override
  public void play() {
    StringBuilder s = new StringBuilder();
    s.append(this.name);
    s.append(", a ");
    s.append(this.numberOfStrings);
    s.append("-stringed instrument, that goes ");
    s.append(this.sound());

    System.out.println(String.join("", s));
  }

  // abstract methods
  public abstract String sound();
}
