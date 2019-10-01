package charsequence;

public class Gnirts implements CharSequence {
    /*
  # Implement CharSequence

  - Check out the
    [CharSequence](https://docs.oracle.com/javase/7/docs/api/java/lang/CharSequence.html)
    interface
  - Create a `Gnirts` class implementing this interface
    - It should have one `String` field that can be set via the constructor
    - Implementing the interface's methods, always think of the field as if it was
      backwards, so at the second position of "this example" there is a 'p'
    - In a `main` method try out all the methods
  - Create a `Shifter` class implementing this interface
    - This charsequence can be set up with a string (that is to be shifted) and a
      number (which will tell how many to shift)
    - Implement the methods so the returned results of them will be shifted
   */

  // fields
  private String oneStringField;

  // constructors

  public Gnirts(String oneStringField) {
    this.oneStringField = oneStringField;
  }


  // methods
  //overrides
  @Override
  public int length() {
    return 0;
  }

  @Override
  public char charAt(int i) {
    return this.oneStringField.charAt(this.oneStringField.length() - 1 - i);

  }

  @Override
  public CharSequence subSequence(int i, int i1) {
    return null;
  }

}
