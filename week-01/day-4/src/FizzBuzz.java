import javax.swing.*;

public class FizzBuzz {
    public static void main(String[] args) {
        // Write a program that prints the numbers from 1 to 100.
        // But for multiples of three print “Fizz” instead of the number
        // and for the multiples of five print “Buzz”.
        // For numbers which are multiples of both three and five print “FizzBuzz”.

        for (int i = 1; i < 101; i++) {
            boolean div3 = (i % 3 == 0);
            boolean div5 = (i % 5 == 0);

            if (div3 && div5) {
                System.out.println("FizzBuzz");
            } else if (div3) {
                System.out.println("Fizz");
            } else if (div5) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
