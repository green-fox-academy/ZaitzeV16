import javax.swing.*;
import java.util.Scanner;
import java.util.ServiceConfigurationError;


public class OddEven {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input,
        // Then prints "Odd" if the number is odd, or "Even" if it is even.

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please give me a number, I am a magician! ");
        int userInput = scanner.nextInt();
        System.out.print(userInput + " is ");

        if (userInput % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }

        System.out.println("See? I told you I am a magician! Cheers!");
    }
}
