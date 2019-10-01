package charsequence;

public class Shifter implements CharSequence {

  // fields
  private String oneStringField;
  private int shift;


  // constructors
  public Shifter(String oneStringField, int shift) {
    this.oneStringField = oneStringField;
    this.shift = shift % this.oneStringField.length();
  }


  // methods
  // overrides
  @Override
  public int length() {
    return 0;
  }

  @Override
  public char charAt(int i) {
    int myIndex = (this.shift + i) % this.oneStringField.length();
    return this.oneStringField.charAt(myIndex);
  }

  @Override
  public CharSequence subSequence(int i, int i1) {
    return null;
  }
}
