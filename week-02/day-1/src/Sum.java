public class Sum {
    public static void main(String[] args) {
        // Create the usual class wrapper and main method on your own.

        // Write a function called `sum` that returns the sum of numbers
        // from zero to the given parameter

        int x = 200;
        int sum = sumOfRange(x);
        System.out.println(sum);
    }

    private static int sumOfRange(int x) {
        int sum = 0;
        for (int i = 0; i <= x; i++) {
            sum += i;
        }

        return sum;
    }
}
