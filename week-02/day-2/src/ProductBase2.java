import java.util.HashMap;

public class ProductBase2 {

  public static void main(String[] args) {
        /*
        Product database 2
        We are going to represent our products in a map where the keys are
        strings representing the product's name and the values are numbers
        representing the product's price.
        // ======================================================================================
        Create a map with the following key-value pairs.
        Product name (key)	Price (value)
              Eggs	          200
              Milk          	200
              Fish          	400
              Apples	        150
              Bread	           50
              Chicken	        550
         */
    HashMap<String, Integer> products = new HashMap<>();
    products.put("Eggs", 200);
    products.put("Milk", 200);
    products.put("Fish", 400);
    products.put("Apples", 150);
    products.put("Bread", 50);
    products.put("Chicken", 550);
    // ======================================================================================
        /*
        Create an application which solves the following problems.
            Which products cost less than 201? (just the name)
            Which products cost more than 150? (name + price)
         */
    // ======================================================================================
    System.out.println("Which products cost less than 201? (just the name)");
    for (HashMap.Entry<String, Integer> myIter : products.entrySet()) {
      if (myIter.getValue() < 201) {
        System.out.println(myIter.getKey() + " is less expensive than 201");
      }
    }
    System.out.println();
    // ======================================================================================
    System.out.println("Which products cost more than 150? (name + price)");
    for (HashMap.Entry<String, Integer> myIter : products.entrySet()) {
      if (myIter.getValue() > 150) {
        System.out.println(
            myIter.getKey() + " is more expensive than 150 and it costs: " + myIter.getValue());
      }
    }
  }
}
