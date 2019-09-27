public class StringAgain {

  public static void main(String[] args) {
    // Given a string, compute recursively a new string
    //  where all the 'x' chars have been removed.
    String example = "xxxWWWxxxxxghjnxggxxfxgjxgj";
    String result = recRemoveX(example);
    System.out.println(result);
  }

  private static String recRemoveX(String example) {
    if (example.length() == 0) {
      return example;
    } else if ("x".equals(String.valueOf(example.charAt(0)))) {
      return recRemoveX(example.substring(1));
    } else {
      return example.charAt(0) + recRemoveX(example.substring(1));
    }
  }
}
