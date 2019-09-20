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
        // ======================================================================================
        // Create a list with the following items.
        //      500, 1000, 1250, 175, 800 and 120
        ArrayList<Integer> expenses = new ArrayList<>();
        expenses.add(500);
        expenses.add(1000);
        expenses.add(1250);
        expenses.add(175);
        expenses.add(800);
        expenses.add(120);
        // ======================================================================================
        // Create an application which solves the following problems.
        //      How much did we spend?
        //      Which was our greatest expense?
        //      Which was our cheapest spending?
        //      What was the average amount of our spendings?
        // ======================================================================================
        // print the greeting to the user
        greeting();

        // call theBoss function - which does almost no work,
        //  just delegates tasks to other functions
        theBoss(expenses);
    }

    private static void theBoss(ArrayList<Integer> expenses) {
        /**
         * This function handles user input and
         *  decides which worker function is needed + calls it.
         *  - keeps asking the user for proper input.
         *
         * @param   expenses    ArrayList<Integer> of the expenses
         */

        String[] options = {"A", "B", "C", "D", "Q"};
        Scanner scanner = new Scanner(System.in);

        String userChoice = scanner.next().toUpperCase();

        // while the user input is not in the options elements
        //  keep asking the user for proper input
        while (!Arrays.asList(options).contains(userChoice)) {
            System.out.println("Sorry, I did not understand, could you try again please?");
            System.out.println("...with one of the given options...");
            userChoice = scanner.next().toUpperCase();
        }

        // if proper input was given, call the corresponding function
        //  to do the work
        // print the return value of the worker
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
        /**
         * This function takes an ArrayList<Integer> as parameter
         *  and calculates the AVERAGE of it's elements.
         *
         *
         * @param   expenses    ArrayList<Integer>
         *
         * @return Double - AVERAGE of the elements inside the parameter
         */

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
        /**
         * This function takes an ArrayList<Integer> as parameter
         *  and looks up the MINIMUM value.
         *
         *
         * @param   expenses    ArrayList<Integer>
         *
         * @return Integer - the MINIMUM value of the given parameter's elements
         */

        return Collections.min(expenses);
    }

    private static int highestExpenses(ArrayList<Integer> expenses) {
        /**
         * This function takes an ArrayList<Integer> as parameter
         *  and looks up the MAXIMUM value.
         *
         *
         * @param   expenses    ArrayList<Integer>
         *
         * @return Integer - the MAXIMUM value of the given parameter's elements
         */

        return Collections.max(expenses);
    }

    private static int sumExpenses(ArrayList<Integer> expenses) {
        /**
         * This function takes an ArrayList<Integer> as parameter
         *  and calculates the SUM of it's elements.
         *
         *
         * @param   expenses    ArrayList<Integer>
         *
         * @return Integer - SUM of the elements inside the parameter
         */

        int result = 0;

        for (int expense : expenses) {
            result += expense;
        }

        return result;
    }

    private static void greeting() {
        /**
         * This function prints the greeting message and the
         *  available options to the console.
         */

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