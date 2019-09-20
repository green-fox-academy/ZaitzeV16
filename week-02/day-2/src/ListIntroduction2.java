import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListIntroduction2 {
    public static void main(String[] args) {
        // List introduction 2
        // =================================================================
        // List A = friuts
        // List B = copyOfFruits
        // Create a list ('List A') which contains the following values
        //     Apple, Avocado, Blueberries, Durian, Lychee
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Avocado");
        fruits.add("Blueberries");
        fruits.add("Durian");
        fruits.add("Lychee");
        // =================================================================
        // Create a new list ('List B') with the values of List A
        ArrayList<String> copyOfFruit = new ArrayList<>(fruits);
        // =================================================================
        System.out.println("Print out whether List A contains Durian or not");
        System.out.println(fruits.contains("Durian"));
        System.out.println();
        // =================================================================
        // Remove Durian from List B
        copyOfFruit.remove("Durian");
        // =================================================================
        // Add Kiwifruit to List A after the 4th element
        fruits.add(4, "Kiwifruit");
        // =================================================================
        System.out.println("Compare the size of List A and List B");
        System.out.print("Size of List A: " + fruits.size() + "\t|\t");
        System.out.println("Size of List B: " + copyOfFruit.size());
        System.out.println("Are the lists equal sized?");
        if (fruits.size() == copyOfFruit.size()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        System.out.println();
        // =================================================================
        System.out.println("Get the index of Avocado from List A");
        System.out.println(fruits.indexOf("Avocado"));
        System.out.println();
        // =================================================================
        System.out.println("Get the index of Durian from List B");
        int temp = copyOfFruit.indexOf("Durian");
        if (temp == -1) {
            System.out.println("List B does not contain Durian");
        } else {
            System.out.println("The index of Durian is: " + temp);
        }
        System.out.println();

        // =================================================================
        // Add Passion Fruit and Pomelo to List B in a single statement
        copyOfFruit.addAll(Arrays.asList("Passion Fruit", "Pomelo"));
        // =================================================================
        System.out.println("Print out the 3rd element from List A");
        System.out.println(fruits.get(2));
    }
}
