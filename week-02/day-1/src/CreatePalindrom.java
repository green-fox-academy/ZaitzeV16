public class CreatePalindrom {
    public static void main(String[] args) {
//        Create a function named create palindrome following your current language's style guide. It should take a string, create a palindrome from it and then return it.
//
//                  Examples
//          input	            output
//            ""	              ""
//        "greenfox"    	"greenfoxxofneerg"
//          "123"           	"123321"

        String sample1 = "";
        String sample2 = "greenfox";
        String sample3 = "123";

        String palindromSample1 = createPalindrom(sample1);
        String palindromSample2 = createPalindrom(sample2);
        String palindromSample3 = createPalindrom(sample3);

        System.out.println(palindromSample1);
        System.out.println(palindromSample2);
        System.out.println(palindromSample3);

        palindromSample1 = cPalindrom(sample1);
        palindromSample2 = cPalindrom(sample2);
        palindromSample3 = cPalindrom(sample3);

        System.out.println(palindromSample1);
        System.out.println(palindromSample2);
        System.out.println(palindromSample3);

    }

    private static String cPalindrom(String word) {
        String result = word;
        String reversedWord;

        StringBuilder stringBuilder = new StringBuilder(word);
        reversedWord = stringBuilder.reverse().toString();
        result += reversedWord;

        return result;
    }

    private static String createPalindrom(String word) {
        String result = word;

        // for solution
        for (int i = word.length() - 1; i >= 0; i--) {
            result += Character.toString(word.charAt(i));
        }

        return result;
    }
}
