package instruments;

public abstract class Instrument {

  /*
  We start with a base, abstract class `Instrument`.

  - it reserves (e.g. protected) the `name` of the instrument
  - it should provide a `play()` method.
   */

  // fields
  protected String name;

  // constructors
  public Instrument(String name) {
    this.name = name;
  }

  // methods
  // abstract methods
  public abstract void play();
}
