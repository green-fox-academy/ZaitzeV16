public class Reverse {
    public static void main(String... args) {
        String reversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";

        // Create a method that can reverse a String, which is passed as the parameter
        // Use it on this reversed string to check it!
        // Try to solve this using charAt() first, and optionally anything else after.
        System.out.println(myReverse(reversed));
    }

    public static String myReverse(String toBeReversed) {
        /**
         * This function takes a String as parameter and reverses it
         *  using StringBuilder.
         *
         *
         * @param toBeReversed  a String which you would like to reverse
         *
         * @return String - the reversed version of the parameter
         */

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = toBeReversed.length() - 1; i >= 0; i--) {
            stringBuilder.append(toBeReversed.charAt(i));
        }
        return stringBuilder.toString();
    }
}