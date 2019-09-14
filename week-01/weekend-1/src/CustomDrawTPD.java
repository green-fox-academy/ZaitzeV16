import java.util.Scanner;


public class CustomDrawTPD {
    public static void main(String[] args) {
        /*
        __________________________________________
        (T)riangle options
        a       |   b       |   c       |   d
                |           |           |
        *       |       *   |   *****   |   *****
        **      |      **   |   ****    |    ****
        ***     |     ***   |   ***     |     ***
        ****    |    ****   |   **      |      **
        *****   |   *****   |   *       |       *
        __________________________________________
        (P)yramid options
             a      |       b
                    |
             *      |   *********
            ***     |    *******
           *****    |     *****
          *******   |      ***
         *********  |       *
        __________________________________________
         (D)iamond options
            a

            *
           ***
          *****
         *******
        *********
         *******
          *****
           ***
            *
        __________________________________________
        */

        // set scanner instance
        Scanner scanner = new Scanner(System.in);

        // the first input is the desired shape
        System.out.println("Please choose the desired shape!");
        System.out.print("(T)riangle\n" +
                "(P)yramid\n" +
                "(D)iamond \n");

        // commented out for testing todo: change back
//        String shape = scanner.next();
//        shape = Character.toString(shape.charAt(0)).toUpperCase();
        String shape = "T";

        while (!shape.equals("T") &&
                !shape.equals("P") &&
                !shape.equals("D")) {
            shape = scanner.next();
            shape = Character.toString(shape.charAt(0)).toUpperCase();
        }

        String option = "";
        // hardcoded to A for now - testing and development
        // todo: change!
        option = "D";
//        String option = Character.toString(shape.charAt(0)).toUpperCase();
        if (shape.equals("T")) {
            System.out.println("The chosen shape is: Triangle");
            System.out.println("__________________________________________\n" +
                    "Triangle options\n" +
                    "a       |   b       |   c       |   d\n" +
                    "        |           |           |\n" +
                    "*       |       *   |   *****   |   *****\n" +
                    "**      |      **   |   ****    |    ****\n" +
                    "***     |     ***   |   ***     |     ***\n" +
                    "****    |    ****   |   **      |      **\n" +
                    "*****   |   *****   |   *       |       *\n" +
                    "__________________________________________");

            while (!option.equals("A") &&
                    !option.equals("B") &&
                    !option.equals("C") &&
                    !option.equals("D")) {
                option = scanner.next();
                option = Character.toString(option.charAt(0)).toUpperCase();
            }
        } else if (shape.equals("P")) {
            System.out.println("The chosen shape is: Pyramid");
            System.out.println("______________________________\n" +
                    "Pyramid options\n" +
                    "     a      |       b\n" +
                    "            |\n" +
                    "     *      |   *********\n" +
                    "    ***     |    *******\n" +
                    "   *****    |     *****\n" +
                    "  *******   |      ***\n" +
                    " *********  |       *\n" +
                    "______________________________");
            while (!option.equals("A") &&
                    !option.equals("B")) {
                option = scanner.next();
                option = Character.toString(option.charAt(0)).toUpperCase();
            }
        } else {
            System.out.println("The chosen shape is: Diamond");
            System.out.println("_________________\n" +
                    " Diamond options\n" +
                    "    a\n" +
                    "\n" +
                    "    *\n" +
                    "   ***\n" +
                    "  *****\n" +
                    " *******\n" +
                    "*********\n" +
                    " *******\n" +
                    "  *****\n" +
                    "   ***\n" +
                    "    *\n" +
                    "_________________");
            while (!option.equals("A")) {
                option = scanner.next();
                option = Character.toString(option.charAt(0)).toUpperCase();
            }
        }

//        System.out.print("How tall shape would you like? ");
        System.out.println("How tall shape would you like? ");
        // commented out for testing todo: change back
//        int height = scanner.nextInt();
        int height = 10;

        /*
        __________________________________________
                    Triangle options
        a       |   b       |   c       |   d
                |           |           |
        *       |       *   |   *****   |   *****
        **      |      **   |   ****    |    ****
        ***     |     ***   |   ***     |     ***
        ****    |    ****   |   **      |      **
        *****   |   *****   |   *       |       *
        __________________________________________
        */

        /*
        area = height^2
        number of stars = (height^2 + height) / 2
        number of spaces = area - number of stars
         */
        // _____________________________________________________________________
        // initializing parameters
        boolean leftStar = false;
        boolean upsideDown = false;
        boolean leftLengthIncrement = false;

        int leftLengthBase = -1;
        int leftLength = -1;

        int rightLengthBase = -1;
        int rightLength = -1;
        // _____________________________________________________________________

        if (shape.equals("T")) {
            // setting parameters according to desired option - Triangle
            if (option.equals("A")) {
                leftStar = true;
                upsideDown = false;
                leftLengthIncrement = true;
                leftLengthBase = 1;

            } else if (option.equals("B")) {
                leftStar = false;
                upsideDown = false;
                leftLengthIncrement = false;
                leftLengthBase = height - 1;

            } else if (option.equals("C")) {
                leftStar = true;
                upsideDown = true;
                leftLengthIncrement = false;
                leftLengthBase = height;

            } else if (option.equals("D")) {
                leftStar = false;
                upsideDown = true;
                leftLengthIncrement = true;

                leftLengthBase = 0;
            }
            rightLengthBase = height - leftLengthBase;
        }

        char leftItem = '*';
        char rightItem = ' ';
        if (!leftStar) {
            leftItem = ' ';
            rightItem = '*';
        }

        // helper variables to check the number of printed elements
        int area = height;
        int currentArea = 0;

        leftLength = leftLengthBase;
        rightLength = rightLengthBase;


        for (int line = 1; line <= height; line++) {
            for (int left = 1; left <= height; left++) {
                if (left <= leftLength) {
                    System.out.print(leftItem);
                } else {
                    System.out.print(rightItem);
                }
                // helper variable for dev and test
                // todo: remove
                currentArea++;
            }
            if (leftLengthIncrement) {
                leftLength++;
                rightLength--;
            } else {
                leftLength--;
                rightLength++;
            }
            System.out.println();
        }
    }
}
