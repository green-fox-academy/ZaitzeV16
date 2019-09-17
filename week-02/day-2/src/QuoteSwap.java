import java.util.*;

public class QuoteSwap {
    public static void main(String... args) {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("What", "I", "do", "create,", "I", "cannot", "not", "understand."));

        // Accidentally I messed up this quote from Richard Feynman.
        // Two words are out of place
        // Your task is to fix it by swapping the right words with code
        // Create a method called quoteSwap().

        // Also, print the sentence to the output with spaces in between.
        System.out.println(quoteSwap(list));
        // Expected output: "What I cannot create I do not understand."

    }

    private static String quoteSwap(ArrayList<String> list) {
        String result = "";
        int indexDo = list.indexOf("do");
        String myDo = list.get(indexDo);
        int indexCannot = list.indexOf("cannot");

        list.set(indexDo, list.get(indexCannot));
        list.set(indexCannot, myDo);

        for (String piece : list) {
            result += " " + piece;
        }

        return result.trim();
    }
}