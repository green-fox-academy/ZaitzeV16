package sharpie;

public class Main {

  public static void main(String[] args) {
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

    Sharpie sharpie = new Sharpie("pink", 20.12f);
    System.out.println(sharpie.color);
    System.out.println(sharpie.width);
    System.out.println(sharpie.inkAmount);
    System.out.println();

    sharpie.use();
    System.out.println(sharpie.color);
    System.out.println(sharpie.width);
    System.out.println(sharpie.inkAmount);
  }
}
