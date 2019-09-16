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
        //output []

        String sample2 = "dog goat dad duck doodle never";
        // output ["og go", "g g", " dad ", "dad", "d d", "dood", "eve"]

        String sample3 = "apple";
        //output []

        String sample4 = "racecar";
        // output ["racecar", "aceca", "cec"]

        String[] palindromSample1 = searchPalindrome(sample1);
        String[] palindromSample2 = searchPalindrome(sample2);
        String[] palindromSample3 = searchPalindrome(sample3);
        String[] palindromSample4 = searchPalindrome(sample4);

        System.out.println(Arrays.toString(palindromSample1));
        System.out.println(Arrays.toString(palindromSample2));
        System.out.println(Arrays.toString(palindromSample3));
        System.out.println(Arrays.toString(palindromSample4));
    }

    private static String[] searchPalindrome(String word) {
        String[] result = new String[0];
        String tempStr = "";
        boolean isPalindrom = false;

        for (int i = 1; i < (word.length() - 1); i++) {
//            if (isPalindrom) {
//                result = Arrays.copyOf(result, result.length + 1);
//                result[result.length - 1] = tempStr;
//            }
            tempStr = "";
//            isPalindrom = false;
            // TODO: palindroms with even length are still missing
            
            for (int j = 1; (j <= i) && j <= (word.length() - i - 1); j++) {
                if (word.charAt(i - j) == word.charAt(i + j)) {
                    // +1 correction because .substring (begin, end-1)
                    tempStr = word.substring(i - j, i + j + 1);
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = tempStr;
//                    isPalindrom = true;
                } else {
                    break;
                }
            }
//            for (int j = 1; )

            // like this, we only get the unique palindromes with odd length
            // we get racecar, but no cec, nor aceca
            // for (int j = 1; (j <= i) && j <= (word.length() - i - 1); j++) {
            // if (word.charAt(i - j) == word.charAt(i + j)) {
            // +1 correction because .substring (begin, end-1)
            // tempStr = word.substring(i - j, i + j + 1);
            // isPalindrom = true;
            // } else {
            // break;
            // }
            // }
        }
        return result;
    }
}
