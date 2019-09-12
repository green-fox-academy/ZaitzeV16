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
        int lastLineLength = 1 + ((userInput - 1) * 2);

        for (int lineNumber = 1; lineNumber <= userInput; lineNumber++) {
            int currentSpaceNeeded = userInput - lineNumber;
            int currentStarNeeded = lastLineLength - (currentSpaceNeeded * 2);

            for (int leftSpace = 0; leftSpace < currentSpaceNeeded; leftSpace++) {
                System.out.print(" ");
            }

            for (int star = 0; star < currentStarNeeded; star++) {
                System.out.print("*");
            }


            for (int rightSpace = 0; rightSpace < currentSpaceNeeded; rightSpace++) {
                System.out.print(" ");
            }

            System.out.println();

        }
    }
}
