import java.util.ArrayList;

public class ShoppingList {
    public static void main(String[] args) {
        /*
        Shopping list
        We are going to represent a shopping list in a list containing strings.

        Create a list with the following items.
            Eggs, milk, fish, apples, bread and chicken
        Create an application which solves the following problems.
            Do we have milk on the list?
            Do we have bananas on the list?
         */
        ArrayList<String> shoppingList = new ArrayList<>();
        shoppingList.add("Eggs");
        shoppingList.add("milk");
        shoppingList.add("fish");
        shoppingList.add("apples");
        shoppingList.add("bread");
        shoppingList.add("chicken");

        System.out.println("Do we have milk on the list?");
        String task1 = "milk";
        if (shoppingList.contains(task1)) {
            System.out.println("Yes, we need " + task1 + "!");
        } else {
            System.out.println("No " + task1 + " needed.");
        }
        System.out.println();

        System.out.println("Do we have bananas on the list?");
        String task2 = "banana";
        if (shoppingList.contains("task2")) {
            System.out.println("Yes, we need " + task2 + "!");
        } else {
            System.out.println("No " + task2 + " needed.");
        }
    }
}
