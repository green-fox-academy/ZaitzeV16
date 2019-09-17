import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIntroduction2 {
    public static void main(String[] args) {
        // Map introduction 2
        // Create a map where the keys are strings and the
        // values are strings with the following initial values
        Map<String, String> isbn = new HashMap<>();
        isbn.put("978-1-60309-452-8", "A Letter to Jo");
        isbn.put("978-1-60309-459-7", "Lupus");
        isbn.put("978-1-60309-444-3", "Red Panda and Moon Bear");
        isbn.put("978-1-60309-461-0", "The Lab");

        /*
            Key	                Value
        978-1-60309-452-8	A Letter to Jo
        978-1-60309-459-7	Lupus
        978-1-60309-444-3	Red Panda and Moon Bear
        978-1-60309-461-0	The Lab
        */

        // Print all the key-value pairs in the following format
        // A Letter to Jo (ISBN: 978-1-60309-452-8)
        // Lupus (ISBN: 978-1-60309-459-7)
        // Red Panda and Moon Bear (ISBN: 978-1-60309-444-3)
        // The Lab (ISBN: 978-1-60309-461-0)
        for (String key : isbn.keySet()) {
            System.out.print(isbn.get(key));
            System.out.print(" (ISBN: ");
            System.out.print(key);
            System.out.println(")");
        }
        System.out.println();

        // Remove the key-value pair with key 978-1-60309-444-3
        isbn.remove("978-1-60309-444-3");

        // Remove the key-value pair with value The Lab
        // set iterator for desired hashmap
        Iterator<Map.Entry<String, String>> myIter = isbn.entrySet().iterator();
        while (myIter.hasNext()) {
            // get iterator for current iteration
            HashMap.Entry<String, String> myEntry = myIter.next();

            if (myEntry.getValue() == "The Lab") {
                isbn.remove(myEntry.getKey());
                break;
            }
        }
        /* OR
        for (HashMap.Entry<String, String> myEntry : isbn.entrySet()) {
            // get iterator for current iteration
            if (myEntry.getValue() == "The Lab") {
                isbn.remove(myEntry.getKey());
                break;
            }
        }
         */

        /*
        Add the following key-value pairs to the map
            Key             	Value
        978-1-60309-450-4	They Called Us Enemy
        978-1-60309-453-5	Why Did We Trust Him?
        */
        isbn.put("978-1-60309-450-4", "They Called Us Enemy");
        isbn.put("978-1-60309-453-5", "Why Did We Trust Him?");

        System.out.println("Print whether there is an associated value with key 478-0-61159-424-8 or not");
        isbn.containsKey("478-0-61159-424-8");
        System.out.println();

        System.out.println("Print the value associated with key 978-1-60309-453-5");
        System.out.println(isbn.get("978-1-60309-453-5"));
    }
}
