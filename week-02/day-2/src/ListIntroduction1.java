import java.util.ArrayList;

public class ListIntroduction1 {
    public static void main(String[] args) {
        // List introduction 1
        // We are going to play with lists.
        // Feel free to use the built-in methods where possible.
        //
        // Create an empty list which will contain names (strings)
        ArrayList<String> names = new ArrayList<>();
        System.out.println();

        System.out.println("Print out the number of elements in the list");
        System.out.println(names.size());
        System.out.println();

        // Add William to the list
        names.add("William");

        System.out.println("Print out whether the list is empty or not");
        System.out.println(names.isEmpty());
        System.out.println();

        // Add John to the list
        names.add("John");

        // Add Amanda to the list
        names.add("Amanda");

        System.out.println("Print out the number of elements in the list");
        System.out.println(names.size());
        System.out.println();

        System.out.println("Print out the 3rd element");
        System.out.println(names.get(2));
        System.out.println();

        System.out.println("Iterate through the list and print out each name");
        //      William
        //      John
        //      Amanda
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println();

        System.out.println("Iterate through the list and print with numbers");
        //      1. William
        //      2. John
        //      3. Amanda
        for (int i = 0; i < names.size(); i++) {
            System.out.print(i + 1 + ". ");
            System.out.println(names.get(i));
        }
        System.out.println();

        // Remove the 2nd element
        names.remove(1);

        System.out.println("Iterate through the list in a reversed order and print out each name");
        //      Amanda
        //      William
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println();

        // Remove all elements
        names.clear();
    }
}
