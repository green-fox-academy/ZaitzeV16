public class SubStrList {
    public static void main(String[] args) {
        //  Create a function that takes a string and a list of string as a parameter
        //  Returns the index of the string in the list where the first string is part of
        //  Only need to find the first occurrence and return the index of that
        //  Returns `-1` if the string is not part any of the strings in the list

        //  Example
        String[] searchArr = new String[]{"this", "is", "what", "I'm", "searching"};
        System.out.println(subStrList("ching", searchArr));
        //  should print: `4`
        System.out.println(subStrList("not", searchArr));
        //  should print: `-1`
    }

    private static int subStrList(String word, String[] searchArr) {
        /**
         * This function takes a String and a String Array as parameters,
         *  iterates through the array and looks for the string.
         *
         *
         * @param   word        String to look for
         * @param   searchArr   String[] - searches the first
         *                          parameter within this array
         *
         * @return Integer - the index of the word inside the array,
         *                   -1 if wasn't found
         */
        for (int i = 0; i < searchArr.length; i++) {
            if (searchArr[i].contains(word)) {
                return i;
            }
        }

        return -1;
    }
}