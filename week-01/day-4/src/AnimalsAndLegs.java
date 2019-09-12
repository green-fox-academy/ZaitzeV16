import java.util.Scanner;


public class AnimalsAndLegs {
    public static void main(String[] args) {
        // Write a program that asks for two integers
        // The first represents the number of chickens the farmer has
        // The second represents the number of pigs owned by the farmer
        // It should print how many legs all the animals have

        Scanner scanner = new Scanner(System.in);

        System.out.print("How many chickens does the farmer have? ");
        int chickens = scanner.nextInt();
        System.out.print("How many pigs does the farmer have? ");
        int pigs = scanner.nextInt();

        int legsOfInfinite = (chickens * 2) + (pigs * 4);
        System.out.println("Legs of the farm (w/o the farmer and his family): " + legsOfInfinite);
    }
}
