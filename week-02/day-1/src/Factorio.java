public class Factorio {
    public static void main(String[] args) {
        //  Create the usual class wrapper
        //  and main method on your own.

        // - Create a function called `factorio`
        //   that returns it's input's factorial

        int someNumber = 5;

        int factorialOf = factorio(someNumber);

        System.out.println(factorialOf);
    }

    private static int factorio(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * (factorio(num - 1));
        }
    }
}
