import java.util.Scanner;


public class PrintBigger {
    public static void main(String[] args) {
        // Write a program that asks for two numbers and prints the bigger one

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please give me 2 numbers!");
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();

        System.out.print("The bigger number is: ");
        if (num1 > num2) {
            System.out.println(num1);
        } else {
            System.out.println(num2);
        }

    }
}
