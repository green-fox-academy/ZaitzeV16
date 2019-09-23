import java.util.Scanner;

public class DivideByZero {

  public static void main(String[] args) {
    // Create a function that takes a number
    // divides ten with it,
    // and prints the result.
    // It should print "fail" if the parameter is 0
    divideTen();
  }

  private static void divideTen() {
    /**
     * This function asks the user to give a number via console input
     *  and prints 10 / userInput to the console.
     * If an Arithmetic Exception occurs, print 'fail'.
     */

    Scanner scanner = new Scanner(System.in);

    System.out.print("please give me a number with which I can divide 10: ");
    int userInput = scanner.nextInt();

    try {
      System.out.println(10 / userInput);
    } catch (ArithmeticException e) {
      System.out.println("fail");
    }
  }
}
