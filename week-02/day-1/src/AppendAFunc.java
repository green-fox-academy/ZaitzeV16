public class AppendAFunc {

  public static void main(String[] args) {
    //  Create the usual class wrapper
    //  and main method on your own.

    // - Create a string variable named `typo` and assign the value `Chinchill` to it
    // - Write a function called `appendAFunc` that gets a string as an input,
    //   appends an 'a' character to its end and returns with a string
    //
    // - Print the result of `appendAFunc(typo)`

    String typo = "Chinchill";

    String correctedWord = appendAFunc(typo);
    System.out.println(correctedWord);
  }

  private static String appendAFunc(String word2Correct) {
    /**
     * This function takes a String as parameter and appends an 'a'
     *    to the end.
     *
     *
     * @param word2Correct - String
     *
     * @return parameter + 'a'
     */

    return word2Correct + "a";
  }
}
