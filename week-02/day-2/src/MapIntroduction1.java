import java.util.HashMap;

public class MapIntroduction1 {

  public static void main(String[] args) {
    // Map introduction 1
    // We are going to play with maps. Feel free to use the built-in methods where possible.
    // ======================================================================================
    // Create an empty map where the keys are integers and the values are characters
    HashMap<Integer, String> myMap = new HashMap<>();
    // ======================================================================================
    System.out.println("Print out whether the map is empty or not");
    if (myMap.isEmpty()) {
      System.out.println("myMap is empty");
    } else {
      System.out.println("myMap is NOT empty");
    }
    System.out.println();
    // ======================================================================================
        /*
        Add the following key-value pairs to the map
            Key	Value
            97	a
            98	b
            99	c
            65	A
            66	B
            67	C
         */
    myMap.put(97, "a");
    myMap.put(98, "b");
    myMap.put(99, "c");
    myMap.put(65, "A");
    myMap.put(66, "B");
    myMap.put(67, "C");
    // ======================================================================================
    System.out.println("Print all the keys");
    System.out.println(myMap.keySet());
    System.out.println();
    // ======================================================================================
    System.out.println("Print all the values");
    System.out.println(myMap.values());
    System.out.println();
    // ======================================================================================
    // Add value D with the key 68
    myMap.put(68, "D");
    // ======================================================================================
    System.out.println("Print how many key-value pairs are in the map");
    // All the same (1 key per value)
    System.out.println(myMap.keySet().size());
    System.out.println(myMap.values().size());
    System.out.println(myMap.entrySet().size());
    System.out.println();
    // ======================================================================================
    System.out.println("Print the value that is associated with key 99");
    System.out.println(myMap.get(99));
    System.out.println();
    // ======================================================================================
    // Remove the key-value pair where with key 97
    myMap.remove(97);
    // ======================================================================================
    System.out.println("Print whether there is an associated value with key 100 or not");
    if (myMap.containsKey(100)) {
      System.out.println("myMap contains a value with key 100");
    } else {
      System.out.println("myMap does NOT contain a value with key 100");
    }
    System.out.println();
    // ======================================================================================
    // Remove all the key-value pairs
    myMap.clear();
  }
}
