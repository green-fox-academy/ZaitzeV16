import java.util.Scanner;


public class DrawSquare {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input, then draws a
        // square like this:
        //
        //
        // %%%%%%
        // %    %
        // %    %
        // %    %
        // %    %
        // %%%%%%
        //
        // The square should have as many lines as the number was

        // ask the user for the length of the sides
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        // 1 or less % sign is not quite a square
        while (userInput < 2) {
            System.out.print("Please type in a higher number! ");
            userInput = scanner.nextInt();
        }

        // iterate through lines
        for (int line = 0; line < userInput; line++) {
            // separate first and last line
            if (line == 0 || line == userInput - 1) {
                for (int i = 0; i < userInput; i++) {
                    System.out.print("%");
                }
            } else {
                System.out.print("%");
                for (int j = 0; j < userInput - 2; j++) {
                    System.out.print(" ");
                }
                System.out.print("%");
            }
            System.out.println();
        }
    }
}
