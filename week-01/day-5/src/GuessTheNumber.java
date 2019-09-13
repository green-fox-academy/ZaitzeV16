import java.util.Scanner;
import java.util.Random;


public class GuessTheNumber {
    public static void main(String[] args) {
        // Write a program that stores a number, and the user has to figure it out.
        // The user can input guesses, after each guess the program would tell one
        // of the following:
        //
        // The stored number is higher
        // The stored number is lower
        // You found the number: 8

        Random random = new Random();
        // generate random number for the random interval
        int randomInterval = random.nextInt(50);
        // generate random number to the user to guess
        int randomNumber = random.nextInt(randomInterval);

        Scanner scanner = new Scanner(System.in);
        // ask the user to guess a number
        System.out.print("Please choose a number: ");
        int userInput = scanner.nextInt();

        while (userInput != randomNumber) {
            if (userInput < randomNumber) {
                System.out.println("The stored number is higher");
            } else if (userInput > randomNumber) {
                System.out.println("The stored number is lower");
            }
            System.out.print("Guess again... ");
            userInput = scanner.nextInt();
        }
         System.out.println("You found the number: " + randomNumber);
    }
}
