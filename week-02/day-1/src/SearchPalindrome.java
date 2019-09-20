import java.util.Arrays;

public class SearchPalindrome {

  public static void main(String[] args) {
//        Create a function named search palindrome following your current language's style guide.
//        It should take a string, search for palindromes that at least 3 characters long and return
//        a list with the found palindromes.
//
//                                      Examples
//                     input                                       	output
//        "dog goat dad duck doodle never"	["og go", "g g", " dad ", "dad", "d d", "dood", "eve"]
//                    "apple"                                       	[]
//                   "racecar"                          	["racecar", "aceca", "cec"]
//                      ""                                          	[]

    String sample1 = "";
    // output []

    String sample2 = "dog goat dad duck doodle never";
    // output ["og go", "g g", " dad ", "dad", "d d", "dood", "eve"]

    String sample3 = "apple";
    // output []

    String sample4 = "racecar";
    // output ["racecar", "aceca", "cec"]

    String[] palindromeSample1 = searchPalindrome(sample1);
    String[] palindromeSample2 = searchPalindrome(sample2);
    String[] palindromeSample3 = searchPalindrome(sample3);
    String[] palindromeSample4 = searchPalindrome(sample4);

    System.out.println(Arrays.toString(palindromeSample1));
    System.out.println(Arrays.toString(palindromeSample2));
    System.out.println(Arrays.toString(palindromeSample3));
    System.out.println(Arrays.toString(palindromeSample4));
  }

  private static boolean checkIfPalindrome(String stringToCheck) {
    /**
     * This function takes a String as parameter and checks
     *  whether it is a palindrome or not.
     *
     *
     * @param stringToCheck - String to analyze
     *
     * @return boolean - true is the parameter is a palindrome,
     *                   false is not
     */

    StringBuilder stringBuilder = new StringBuilder(stringToCheck);
    String reversedWord = stringBuilder.reverse().toString();

    if (stringToCheck.equals(reversedWord)) {
      return true;
    } else {
      return false;
    }
  }

  private static String[] searchPalindrome(String word) {
    /**
     * This function takes a String as parameter, looks for
     *  every consecutive substring and calls the 'checkIfPalindrome'
     *  function to decide whether the substrings are palindromes or not.
     *
     *
     * @param word - String to analyze
     *
     * @return String[] - every palindrome the parameter contains
     */

    String[] palindromes = new String[0];
    int wordLen = word.length();

    for (int currLen = 3; currLen <= wordLen; currLen++) {
      for (int start = 0; start <= (wordLen - currLen); start++) {
        String currSubStr = word.substring(start, start + currLen);
        if (checkIfPalindrome(currSubStr)) {
          palindromes = Arrays.copyOf(palindromes, palindromes.length + 1);
          palindromes[palindromes.length - 1] = currSubStr;
        }
      }
    }
    return palindromes;
  }
}
