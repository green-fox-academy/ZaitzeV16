import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Calculator {
    public static void main(String... args) {
        // Create a simple calculator application which reads the parameters from the prompt
        // and prints the result to the prompt.

        // It should support the following operations,
        // create a method named "calculate()":
        // +, -, *, /, % and it should support two operands.
        // The format of the expressions must be: {operation} {operand} {operand}.
        // Examples: "+ 3 3" (the result will be 6) or "* 4 4" (the result will be 16)

        // You can use the Scanner class
        // It should work like this:

        // Start the program
        // It prints: "Please type in the expression:"
        // Waits for the user input
        // Print the result to the prompt
        // Exit

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please type in the expression (+ 3 3): ");
        String userInput = scanner.nextLine();

        System.out.println(calculate(userInput));
    }

    private static String calculate(String userInput) {
        String result = "";
        String[] items = userInput.split(" ");

        double operand1 = Integer.parseInt(items[1]);
        double operand2 = Integer.parseInt(items[2]);

        // + - * / %
        switch (items[0]) {
            case "+":
                result = String.valueOf(operand1 + operand2);
                break;
            case "-":
                result = String.valueOf(operand1 - operand2);
                break;
            case "*":
                result = String.valueOf(operand1 * operand2);
                break;
            case "/":
                result = String.valueOf(operand1 / operand2);
                break;
            case "%":
                result = String.valueOf(operand1 % operand2);
                break;
        }

        // round to 3 decimal places
        BigDecimal bd = new BigDecimal(Double.parseDouble(result));
        bd = bd.setScale(3, RoundingMode.HALF_UP);
        result = String.valueOf(bd);

        return result;
    }
}