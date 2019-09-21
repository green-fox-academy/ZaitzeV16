import java.util.*;

public class Matchmaking {

  public static void main(String... args) {
    ArrayList<String> girls = new ArrayList<String>(
        Arrays.asList("Eve", "Ashley", "Claire", "Kat", "Jane"));
    ArrayList<String> boys = new ArrayList<String>(
        Arrays.asList("Joe", "Fred", "Tom", "Todd", "Neef", "Jeff"));

    // Write a method that joins the two lists by matching one girl with one boy into a new list
    // If someone has no pair, he/she should be the element of the list too
    // Exepected output: "Eve", "Joe", "Ashley", "Fred"...

    System.out.println(makingMatches(girls, boys));
  }

  private static ArrayList<String> makingMatches(
      ArrayList<String> arrList1,
      ArrayList<String> arrList2
  ) {
    /**
     * This function takes 2 ArrayLists of String as parameters and
     *  merges their elements 1 by 1, starting with the first parameter.
     *
     * If the ArrayLists are not the same size, the function just puts
     *  the remaining element at the end of the result.
     *
     *
     * @param arrList1  first parameter - ArrayList<String>, EVEN indices
     * @param arrList2  second parameter - ArrayList<String>, ODD indices
     *
     * @return the merged ArrayList<String> of the parameters
     */

    ArrayList<String> matchList = new ArrayList<>();

    // set iterators
    Iterator<String> iterArrList1 = arrList1.iterator();
    Iterator<String> iterArrList2 = arrList2.iterator();

    while (iterArrList1.hasNext() || iterArrList2.hasNext()) {
      if (iterArrList1.hasNext()) {
        matchList.add(iterArrList1.next());
      }
      if (iterArrList2.hasNext()) {
        matchList.add(iterArrList2.next());
      }
    }
    return matchList;
  }
}