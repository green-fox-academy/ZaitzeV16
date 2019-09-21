import java.util.Random;
import java.util.Scanner;

public class GuessMyNumber {

  public static void main(String[] args) {
        /*
        Guess my number
        Exercise
        Write a program where the program chooses a number between 1 and 100.
        The player is then asked to enter a guess. If the player guesses wrong,
        then the program gives feedback and ask to enter an other guess until the guess is correct.

        Make the range customizable (ask for it before starting the guessing).
        You can add lives. (optional)
        Example
        I've the number between 1-100. You have 5 lives.

        > 20
        Too high. You have 4 lives left.

        > 10
        Too low. You have 3 lives left.

        > 15
        Congratulations. You won!
         */

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    int lives = 5;
    int guess = -1;

    int rangeMax = -1;
    int targetNumber = -1;

    System.out.println("Let's play a game! :)");
    System.out.println("How hard would you like the game to be?");
    System.out.println("\t(A) easy");
    System.out.println("\t(B) normal");
    System.out.println("\t(C) hard");
    System.out.println("\t(D) don't you dare!!!");

    String option = scanner.next();
    if ("A".equals(option.toUpperCase())) {
      rangeMax = 20;
    } else if ("B".equals(option.toUpperCase())) {
      rangeMax = 100;
    } else if ("C".equals(option.toUpperCase())) {
      rangeMax = 250;
    } else if ("D".equals(option.toUpperCase())) {
      rangeMax = random.nextInt(987654321);
    }

    targetNumber = random.nextInt(rangeMax);

    while (lives > 0) {
      System.out.print("Please choose a number! ");
      guess = scanner.nextInt();
      System.out.println(guess);

      if (guess != targetNumber) {
        lives--;
        if (guess > targetNumber) {
          System.out.println("Too high. You have " + lives + " lives left.");
        } else {
          System.out.println("Too low. You have " + lives + " lives left.");
        }
      } else {
        System.out.println("Congratulations. You won!");
        break;
      }
    }
    if (lives == 0) {
      System.out.println("You lost!");
    }
  }
}
