public class Strings {

  public static void main(String[] args) {
    // Given a string, compute recursively (no loops) a new string
    //  where all the lowercase 'x' chars have been changed to 'y' chars.
    String example1 = "xxxasdxxxxxxxjkhxgxdfgxfhxfgxxxxxxxxxx";

    String result = recChangeXToY(example1);
    System.out.println(result);
  }

  private static String recChangeXToY(String example1) {
    if (example1.length() == 0) {
      return example1;
    } else {
      if ("x".equals(String.valueOf(example1.charAt(0)))) {
        example1 = "y" + example1.substring(1);
      }
      return example1.charAt(0) + recChangeXToY(example1.substring(1));
    }
  }
}
