public class Swap {
    public static void main(String[] args) {
        // Swap the values of the variables
        int a = 123;
        int b = 526;

        System.out.println("a is: " + a);
        System.out.println("b is: " + b);
        System.out.println();

        int helperNumber = a;
        a = b;
        b = helperNumber;

        System.out.println("a is: " + a);
        System.out.println("b is: " + b);
    }
}
