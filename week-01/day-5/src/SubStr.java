public class SubStr {
    public static void main(String[] args) {
        //  Create a function that takes two strings as a parameter
        //  Returns the starting index where the second one is starting in the first one
        //  Returns `-1` if the second string is not in the first one

        //  Example:
        //  should print: `17`
        System.out.println(subStr("this is what I'm searching in", "searching"));

        //  should print: `-1`
        System.out.println(subStr("this is what I'm searching in", "not"));
    }

    public static int subStr(String input, String q) {
        int indexOfStart = input.indexOf(q);

        // if String.indexOf(substring)
        // does not find a match, returns -1
        // because of this, we only need to return indexOfStart variable
        return indexOfStart;
    }
}