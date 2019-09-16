import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
//        Create a function named anagram following your current language's style guide.
//        It should take two strings and return a boolean value depending on whether its
//        an anagram or not.
//
//                  Examples
//        input 1	input 2	output
//        "dog" 	"god"	 true
//        "green"   "fox"	 false

        String sample1 = "dog";
        String sample2 = "god";
        boolean isAnagram = anagram(sample1, sample2);

        System.out.println(isAnagram);
    }

    private static boolean anagram(String sample1, String sample2) {
        boolean result = false;

        // split word by character
        String[] firstWord = sample1.split("");
        String[] secondWord = sample2.split("");

        // sort the arrays
        Arrays.sort(firstWord);
        Arrays.sort(secondWord);

        if (Arrays.equals(firstWord, secondWord)) {
            return true;
        }
        return result;
    }
}
