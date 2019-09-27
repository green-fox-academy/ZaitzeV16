public class StringAgainAndAgain {

  public static void main(String[] args) {
    // Given a string, compute recursively a new string
    //  where all the adjacent chars are now separated by a *
    String example = "WWWWWWWWWW";
    String result = recSeparateWithAsterisk(example);
    System.out.println(result);
  }

  private static String recSeparateWithAsterisk(String example) {
    if (example.length() <= 1) {
      return example;
    } else {
      return example.charAt(0) + "*" + recSeparateWithAsterisk(example.substring(1));
    }
  }
}
