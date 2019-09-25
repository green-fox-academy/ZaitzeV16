package sharpie;

public class Sharpie {

  /*
  Create Sharpie class
    We should know about each sharpie their color (which should be a string),
    width (which will be a floating point number),
    inkAmount (another floating point number)
    When creating one, we need to specify the color and the width
    Every sharpie is created with a default 100 as inkAmount
    We can use() the sharpie objects
      which decreases inkAmount
   */
  String color;
  float width;
  float inkAmount;

  // constructors
  public Sharpie(String color, float inkAmount) {
    this.color = color;
    this.width = 100;
    this.inkAmount = inkAmount;
  }

  // functions
  public void use() {
    this.inkAmount--;
  }
}
