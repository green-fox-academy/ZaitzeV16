import java.util.Scanner;

public class DrawDiagonal {

  public static void main(String[] args) {
    // Write a program that reads a number from the standard input, then draws a
    // square like this:
    // %%%%%
    // %%  %
    // % % %
    // %  %%
    // %%%%%
    // The square should have as many lines as the number was

    // ask the user for the length of the sides
    Scanner scanner = new Scanner(System.in);
    System.out.println("Height of the Square: ");
    int userInput = scanner.nextInt();

    // 1 or less % sign is not quite a square
    while (userInput < 2) {
      System.out.print("Please type in a higher number! ");
      userInput = scanner.nextInt();
    }

    for (int row = 0; row < userInput; row++) {
      for (int column = 0; column < userInput; column++) {
        boolean isPercent = (
          // 0. row  OR    diagonal     OR       last row         OR
          (row == 0) || (row == column) || (row == userInput - 1) ||
            // 0. column  OR    last column
            (column == 0) || (column == userInput - 1)
        );

        if (isPercent) {
          System.out.print("%");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
