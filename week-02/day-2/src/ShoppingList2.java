import java.util.HashMap;
import java.util.Map;

public class ShoppingList2 {
    public static void main(String[] args) {
        /*
        Shopping list 2

        Represent the following products with their prices
        Product	                Amount
        Milk	                1.07
        Rice	                1.59
        Eggs	                3.14
        Cheese	                12.60
        Chicken Breasts	        9.40
        Apples	                2.31
        Tomato	                2.58
        Potato	                1.75
        Onion	                1.10
         */
        HashMap<String, Double> productMap = new HashMap<>();
        productMap.put("Milk", 1.07);
        productMap.put("Rice", 1.59);
        productMap.put("Eggs", 3.14);
        productMap.put("Cheese", 12.60);
        productMap.put("Chicken Breasts", 9.40);
        productMap.put("Apples", 2.31);
        productMap.put("Tomato", 2.58);
        productMap.put("Potato", 1.75);
        productMap.put("Onion", 1.10);

        /*
        Represent Bob's shopping list
        _______________________________
        Product	                Amount
        Milk	                  3
        Rice	                  2
        Eggs	                  2
        Cheese	                  1
        Chicken Breasts	          4
        Apples	                  1
        Tomato	                  2
        Potato	                  1
         */
        HashMap<String, Integer> bobMap = new HashMap<>();
        bobMap.put("Milk", 3);
        bobMap.put("Rice", 2);
        bobMap.put("Eggs", 2);
        bobMap.put("Cheese", 1);
        bobMap.put("Chicken Breasts", 4);
        bobMap.put("Apples", 1);
        bobMap.put("Tomato", 2);
        bobMap.put("Potato", 1);

        /*
        Represent Alice's shopping list
        _______________________________
        Product	                Amount
        Rice	                  1
        Eggs	                  5
        Chicken Breasts	          2
        Apples	                  1
        Tomato	                 10
         */
        HashMap<String, Integer> aliceMap = new HashMap<>();
        aliceMap.put("Rice", 1);
        aliceMap.put("Eggs", 5);
        aliceMap.put("Chicken Breasts", 2);
        aliceMap.put("Apples", 1);
        aliceMap.put("Tomato", 10);

        /*
        _______________________________
        Create an application which solves the following problems.
            How much does Bob pay?
            How much does Alice pay?
            Who buys more Rice?
            Who buys more Potato?
            Who buys more different products?
            Who buys more products? (piece)
         */

        System.out.println("How much does Bob pay?");
        double bobExpense = 0.0;
        for (HashMap.Entry<String, Integer> myIter : bobMap.entrySet()) {
            if (productMap.containsKey(myIter.getKey())) {
                bobExpense += productMap.get(myIter.getKey()) * myIter.getValue();
            }
        }
        System.out.println("Bob pays: " + bobExpense);
        System.out.println();

        System.out.println("How much does Alice pay?");
        double aliceExpense = 0.0;
        for (HashMap.Entry<String, Integer> myIter : aliceMap.entrySet()) {
            if (productMap.containsKey(myIter.getKey())) {
                aliceExpense += productMap.get(myIter.getKey()) * myIter.getValue();
            }
        }
        System.out.println("Alice pays: " + aliceExpense);
        System.out.println();

        System.out.println("Who buys more Rice?");
        String product1 = "Rice";
        if (!bobMap.containsKey(product1) && aliceMap.containsKey(product1)) {
            System.out.println("Alice buys more " + product1);
        } else if (bobMap.containsKey(product1) && !aliceMap.containsKey(product1)) {
            System.out.println("Bob buys more " + product1);
        } else if (bobMap.get(product1) > aliceMap.get(product1)) {
            System.out.println("Bob buys more " + product1);
        } else if (bobMap.get(product1) < aliceMap.get(product1)) {
            System.out.println("Alice buys more " + product1);
        } else {
            System.out.println("They buy the same amount of " + product1);
        }
        System.out.println();

        System.out.println("Who buys more Potato?");
        String product2 = "Potato";
        if (!bobMap.containsKey(product2) && aliceMap.containsKey(product2)) {
            System.out.println("Alice buys more " + product2);
        } else if (bobMap.containsKey(product2) && !aliceMap.containsKey(product2)) {
            System.out.println("Bob buys more " + product2);
        } else if (bobMap.get(product2) > aliceMap.get(product2)) {
            System.out.println("Bob buys more " + product2);
        } else if (bobMap.get(product2) < aliceMap.get(product2)) {
            System.out.println("Alice buys more " + product2);
        } else {
            System.out.println("They buy the same amount of " + product2);
        }
        System.out.println();

        System.out.println("Who buys more different products?");
        int bobProducts = bobMap.size();
        int aliceProducts = aliceMap.size();
        if (bobProducts > aliceProducts) {
            System.out.println("Bob buys more different products");
        } else if (bobProducts < aliceProducts) {
            System.out.println("Alice buys more different products");
        } else {
            System.out.println("They buy the same amount of different products");
        }
        System.out.println();

        System.out.println("Who buys more products? (piece)");
        int bobItems = 0;
        int aliceItems = 0;
        // bob
        for (HashMap.Entry<String, Integer> myIter : bobMap.entrySet()) {
            bobItems += myIter.getValue();
        }
        // alice
        for (HashMap.Entry<String, Integer> myIter : aliceMap.entrySet()) {
            aliceItems += myIter.getValue();
        }
        if (bobItems > aliceItems) {
            System.out.println("Bob");
        } else if (bobItems < aliceItems) {
            System.out.println("Alice");
        } else {
            System.out.println("Same number of items");
        }
        System.out.println();
    }
}
