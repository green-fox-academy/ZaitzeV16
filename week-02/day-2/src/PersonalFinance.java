import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PersonalFinance {
    public static void main(String[] args) {
        // Personal finance
        // We are going to represent our expenses in a list containing integers.

        // Create a list with the following items.
        //      500, 1000, 1250, 175, 800 and 120
        ArrayList<Integer> expenses = new ArrayList<>();
        expenses.add(500);
        expenses.add(1000);
        expenses.add(1250);
        expenses.add(175);
        expenses.add(800);
        expenses.add(120);

        // Create an application which solves the following problems.
        //      How much did we spend?
        //      Which was our greatest expense?
        //      Which was our cheapest spending?
        //      What was the average amount of our spendings?

        String[] options = {"A", "B", "C", "D", "Q"};
        Scanner scanner = new Scanner(System.in);

        // print the greeting to the user
        greeting();
        String userChoice = scanner.next().toUpperCase();

        while (!Arrays.asList(options).contains(userChoice)) {
            userChoice = scanner.next().toUpperCase();
        }
        switch (userChoice) {
            case "A":
                //      (A) How much did we spend?
                int sum = sumExpenses(expenses);
                System.out.println("The sum of you expenses is: " + sum);
                break;
            case "B":
                //      (B) Which was our greatest expense?
                int highest = highestExpenses(expenses);
                System.out.println("Your highest expense was: " + highest);
                break;
            case "C":
                //      (C) Which was our cheapest spending?
                int lowest = lowestExpense(expenses);
                System.out.println("Your lowest expense was: " + lowest);
                break;
            case "D":
                //      (D) What was the average amount of our spendings?
                double avg = avgExpense(expenses);
                System.out.println("Your average expense is: " + avg);
                break;
            case "Q":
                System.out.println("See you next time!");
                break;
        }
    }

    private static double avgExpense(ArrayList<Integer> expenses) {
        double result = 0.0;

        for (int expense : expenses) {
            result += expense;
        }
        result /= expenses.size();

        // set to 2 decimal places
        BigDecimal bigDecimal = new BigDecimal(Double.toString(result));
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);

        result = bigDecimal.doubleValue();

        return result;
    }

    private static int lowestExpense(ArrayList<Integer> expenses) {
        return Collections.min(expenses);
    }

    private static int highestExpenses(ArrayList<Integer> expenses) {
        return Collections.max(expenses);
    }

    private static int sumExpenses(ArrayList<Integer> expenses) {
        int result = 0;

        for (int expense : expenses) {
            result += expense;
        }

        return result;
    }

    private static void greeting() {
        String welcome = "Greetings!\n" +
                "What would you like to do?\n" +
                "\t(A) - Sum of expenses\n" +
                "\t(B) - Greatest expense\n" +
                "\t(C) - Lowest expense\n" +
                "\t(D) - Average expense\n" +
                "\t(Q) - Quit the program\n";

        System.out.println(welcome);
    }
}
