import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ProductBase {
    public static void main(String[] args) {
        /*
        Product database
        We are going to represent our products in a map where the keys are
        strings representing the product's name and the values are numbers
        representing the product's price.

        Create a map with the following key-value pairs.

            Product name (key)	Price (value)
                  Eggs          	200
                  Milk          	200
                  Fish	            400
                  Apples        	150
                  Bread	             50
                  Chicken	        550
        Create an application which solves the following problems.
         */
        HashMap<String, Integer> products = new HashMap<>();
        products.put("Eggs", 200);
        products.put("Milk", 200);
        products.put("Fish", 400);
        products.put("Apples", 150);
        products.put("Bread", 50);
        products.put("Chicken", 550);

        System.out.println("How much is the fish?");
        System.out.println(products.get("Fish"));
        System.out.println();

        System.out.println("What is the most expensive product?");
        int myMax = Collections.max(products.values());
        for (HashMap.Entry<String, Integer> myIter : products.entrySet()) {
            if (myIter.getValue() == myMax) {
                System.out.println(myIter.getKey() + " is the most expensive.");
                break;
            }
        }
        System.out.println();

        System.out.println("What is the average price?");
        int sum = 0;
        for (int value : products.values()) {
            sum += value;
        }
        double avg = sum / products.values().size();
        System.out.println("The average price is: " + avg);
        System.out.println();

        System.out.println("How many products' price is below 300?");
        int counter = 0;
        for (int value : products.values()) {
            if (value < 300) {
                counter++;
            }
        }
        System.out.println(counter);
        System.out.println();

        System.out.println("Is there anything we can buy for exactly 125?");
        int myCounter = 0;
        for (HashMap.Entry<String, Integer> myIter : products.entrySet()) {
            if (myIter.getValue() == 125) {
                myCounter++;
                System.out.println(myIter.getKey() + " is exactly 125");
            }
        }
        if (myCounter == 0) {
            System.out.println("There are not items with the exact price of 125.");
        }
        System.out.println();

        System.out.println("What is the cheapest product?");
        int min = 0;
        for (HashMap.Entry<String, Integer> myIter : products.entrySet()) {
            if (min == 0) {
                min = myIter.getValue();
            }
            if (myIter.getValue() < min) {
                min = myIter.getValue();
            }
        }
        System.out.println("The cheapest is: " + min);
    }
}
