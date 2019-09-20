public class CreatePalindrome {

  public static void main(String[] args) {
    /*
    Create a function named create palindrome following your current language's style guide.
    It should take a string, create a palindrome from it and then return it.
                   Examples
          input	            output
            ""	              ""
        "greenfox"    	"greenfoxxofneerg"
          "123"           	"123321"

     (2 solutions)
     */

    String sample1 = "";
    String sample2 = "greenfox";
    String sample3 = "123";

    String palindromeSample1 = createPalindrome(sample1);
    String palindromeSample2 = createPalindrome(sample2);
    String palindromeSample3 = createPalindrome(sample3);

    System.out.println(palindromeSample1);
    System.out.println(palindromeSample2);
    System.out.println(palindromeSample3);
    //====================================================
    palindromeSample1 = cPalindrome(sample1);
    palindromeSample2 = cPalindrome(sample2);
    palindromeSample3 = cPalindrome(sample3);

    System.out.println(palindromeSample1);
    System.out.println(palindromeSample2);
    System.out.println(palindromeSample3);

  }

  private static String cPalindrome(String word) {
    /**
     * This function takes a String as parameter, creates
     *  the reverse of it and returns the concatenated String.
     *
     * TLDR: creates a palindrome from the parameter
     *
     *
     * @param   word - String to be palindromized
     *
     * @@return String - palindrome version of the parameter
     */

    String result = word;
    String reversedWord;

    StringBuilder stringBuilder = new StringBuilder(word);
    reversedWord = stringBuilder.reverse().toString();
    result += reversedWord;

    return result;
  }

  private static String createPalindrome(String word) {
    /**
     * This function takes a String as parameter, creates
     *  the reverse of it and returns the concatenated String.
     *
     * TLDR: creates a palindrome from the parameter
     *
     *
     * @param   word - String to be palindromized
     *
     * @@return String - palindrome version of the parameter
     */

    String result = word;

    // for solution
    for (int i = word.length() - 1; i >= 0; i--) {
      result += Character.toString(word.charAt(i));
    }

    return result;
  }
}
