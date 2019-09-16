public class Doubling {
    public static void main(String[] args) {
        // - Create an integer variable named `baseNum` and assign the value `123` to it
        // - Create a function called `doubling` that doubles it's input parameter
        //      and returns with an integer
        // - Print the result of `doubling(baseNum)`

        int baseNum = 123;
        int doubledNum = doubling(baseNum);
        System.out.println(doubledNum);
    }

    private static int doubling(int num) {
        return num * 2;
    }
}
