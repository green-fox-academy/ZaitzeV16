import java.util.Scanner;


public class DrawPyramid {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input, then draws a
        // pyramid like this:
        //
        //
        //    *
        //   ***
        //  *****
        // *******
        //
        // The pyramid should have as many lines as the number was
//        userInput 4   left 0  star 1  right 0

        Scanner scanner = new Scanner(System.in);

        int userInput = scanner.nextInt();
        // int lastLineLength = userInput * 2 - 1;
        // part of the math :)

        for (int lineNumber = 1; lineNumber <= userInput; lineNumber++) {
            // int currentSpaceNeeded = userInput - lineNumber;
            // int currentStarNeeded = lastLineLength - (currentSpaceNeeded * 2);
            // did some math...
            int currentSpaceNeeded = userInput - lineNumber;
            int currentStarNeeded = lineNumber * 2 - 1;

            for (int leftSpace = 0; leftSpace < currentSpaceNeeded; leftSpace++) {
                System.out.print(" ");
            }

            for (int star = 0; star < currentStarNeeded; star++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }
}
