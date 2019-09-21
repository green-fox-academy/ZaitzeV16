import java.util.*;

public class QuoteSwap {

  public static void main(String... args) {
    ArrayList<String> list = new ArrayList<String>(
        Arrays.asList("What", "I", "do", "create,", "I", "cannot", "not", "understand."));

    // Accidentally I messed up this quote from Richard Feynman.
    // Two words are out of place
    // Your task is to fix it by swapping the right words with code
    // Create a method called quoteSwap().

    // Also, print the sentence to the output with spaces in between.
    System.out.println(quoteSwap(list));
    // Expected output: "What I cannot create I do not understand."
  }

  private static String quoteSwap(ArrayList<String> wordsAL) {
    /**
     * This function takes an ArrayList<String> as parameter,
     *  find the index of the word "do" and "cannot", changes them
     *  and joins the words with a " " delimiter.
     *
     *
     * @param   wordsAL ArrayList<String> - list of the words to join
     *
     * @return String - items of param as a joined String
     */

    String result = "";
    int indexDo = wordsAL.indexOf("do");
    String myDo = wordsAL.get(indexDo);
    int indexCannot = wordsAL.indexOf("cannot");

    wordsAL.set(indexDo, wordsAL.get(indexCannot));
    wordsAL.set(indexCannot, myDo);

    result = String.join(" ", wordsAL);

        /* OR
        for (String piece : wordsAL) {
            result += " " + piece;
        }
        return result.trim();
         */
    return result;
  }
}