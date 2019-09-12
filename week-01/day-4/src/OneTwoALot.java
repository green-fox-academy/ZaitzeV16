import java.util.Scanner;


public class OneTwoALot {
    public static void main(String[] args) {
        // Write a program that reads a number form the standard input,
        // If the number is zero or smaller it should print: Not enough
        // If the number is one it should print: One
        // If the number is two it should print: Two
        // If the number is more than two it should print: A lot

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please give me a number: ");
        int userInput = scanner.nextInt();

        if (userInput <= 0) {
            System.out.println("Not enough");
        } else if (userInput == 1) {
            System.out.println("One");
        } else if (userInput == 2) {
            System.out.println("Two");
        } else {
            // Only else needed, because we are only working with integers,
            // so we don't have to consider numbers between 0 and 1;
            //                                              1 and 2
            // if (userInput > 2){
            // System.out.println("A lot");
            // }
            System.out.println("A lot");
        }

    }
}
