import java.util.Scanner;


public class ParametricAverage {
    public static void main(String[] args) {
        // Write a program that asks for a number.
        // It would ask this many times to enter an integer,
        // if all the integers are entered, it should print the sum and average of these
        // integers like:
        //
        // Sum: 22, Average: 4.4

        Scanner scanner = new Scanner(System.in);
        // ask the user to guess a number
        System.out.print("Please choose a number: ");
        int userInput = scanner.nextInt();

        // initialize sum for later use
        int sum = 0;

        for (int i = 0; i < userInput; i++) {
            if (i == 0) {
                System.out.print("Please choose the first number: ");
            } else {
                System.out.print("Please choose the next number: ");
            }
            sum += scanner.nextInt();
        }

        System.out.print("Sum: " + sum + ", Average: " + ((double) (sum) / userInput));


    }
}
