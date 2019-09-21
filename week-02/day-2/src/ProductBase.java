import java.math.BigDecimal;
import java.math.RoundingMode;
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
        // ======================================================================================
        Create a map with the following key-value pairs.
            Product name (key)	Price (value)
                  Eggs          	200
                  Milk          	200
                  Fish	          400
                  Apples        	150
                  Bread	           50
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
    // ======================================================================================
    System.out.println("How much is the fish?");
    System.out.println(products.get("Fish"));
    System.out.println();
    // ======================================================================================
    System.out.println("What is the most expensive product?");
    // this code snippet looks up all the products
    //  for the highest value
    int myMax = Collections.max(products.values());
    ArrayList<String> keysOfMax = new ArrayList<>();

    for (HashMap.Entry<String, Integer> myIter : products.entrySet()) {
      if (myIter.getValue() == myMax) {
        keysOfMax.add(myIter.getKey());
      }
    }

    // there will be at least 1 item in keysOfMax if products is not empty
    if (keysOfMax.size() == 1) {
      System.out.println(keysOfMax.get(0) + " is the most expensive.");
    } else {
      System.out.println("The most expensive products are: ");
      System.out.println(keysOfMax.toString());
    }
    System.out.println();
    // ======================================================================================
    System.out.println("What is the average price?");
    int sum = 0;
    for (int value : products.values()) {
      sum += value;
    }

    // set decimal precision to 2 decimal places
    BigDecimal bigDecimal = new BigDecimal((double) sum / products.size());
    BigDecimal avg = bigDecimal.setScale(2, RoundingMode.HALF_UP);

    System.out.println("The average price is: " + avg);
    System.out.println();
    // ======================================================================================
    System.out.println("How many products' price is below 300?");
    int counter = 0;
    for (int value : products.values()) {
      if (value < 300) {
        counter++;
      }
    }
    System.out.println(counter);
    System.out.println();
    // ======================================================================================
    System.out.println("Is there anything we can buy for exactly 125?");
    if (products.containsValue(125)) {
      for (HashMap.Entry<String, Integer> myIter : products.entrySet()) {
        if (myIter.getValue() == 125) {
          System.out.println(myIter.getKey() + " is exactly 125");
        }
      }
    } else {
      System.out.println("There are not items with the exact price of 125.");
    }
    System.out.println();
    // ======================================================================================
    System.out.println("What is the cheapest product?");

    System.out.println("The cheapest product(s) is(are): ");
    int cheapestValue = Collections.min(products.values());
    for (HashMap.Entry<String, Integer> myIter : products.entrySet()) {
      if (myIter.getValue().equals(cheapestValue)) {
        System.out.println("\t" + myIter.getKey());
      }
    }
  }
}
