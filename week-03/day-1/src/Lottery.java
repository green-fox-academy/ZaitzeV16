import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Lottery {

  public static void main(String[] args) {
    // Create a method that finds the 5 most common lottery numbers in lottery.csv

    // use this parameter to set the result to the most frequent 'n' numbers
    int n = 5;
    String[] commonLotteryNumbers = getNFrequentNumbers(n);
    System.out
        .println(n + " most common Lottery numbers are: " + Arrays.toString(commonLotteryNumbers));
  }

  private static String[] getNFrequentNumbers(int n) {
    /**
     * This function opens the 'lottery.csv', filters it to the relevant data and
     *  gathers the 'n' most frequent lottery numbers and returns them in a String[].
     *
     * Uses 4 other functions:
     *                        - to open the file
     *                        - to look for the highest value
     *                        - to look for the highest keys
     *                        - to filter the keys to 'n'
     *
     *
     * @param n   int - number of the most frequent lottery numbers in 'lottery.csv'
     *
     * @return String[] - with the most frequent lottery numbers in 'lottery.csv'
     */

    Path path = Paths.get("./lottery.csv");
    ArrayList<String> content = Doubled.getFileContent(path);

    HashMap<String, Integer> lotteryByNumbers = new HashMap<>();

    for (String line : content) {
      String[] linePieces = line.split(";");
      int bound = linePieces.length - 1;

      for (int i = bound - 4; i <= bound; i++) {
        if (!lotteryByNumbers.containsKey(linePieces[i])) {
          lotteryByNumbers.put(linePieces[i], 1);
        } else {
          int currValue = lotteryByNumbers.get(linePieces[i]);
          lotteryByNumbers.put(linePieces[i], currValue + 1);
        }
      }
    }
    return getNHighestKeys(lotteryByNumbers, n);
  }


  private static String[] getNHighestKeys(HashMap<String, Integer> toBeFiltered, int nHighest) {
    /**
     * This function looks through the first parameter and collects the N highest keys
     *  related to the N highest values. In case of multiple keys having the same value,
     *  all of the keys are collected.
     *  !!!Key-Value pairs are collected, not just keys!!!
     *
     *
     * @param toBeFiltered     HashMap<String, Integer> - from where you would like
     *                                                    collect the key-value pairs
     * @param nHighest         int                      - the number of the highest values
     *
     * @return HashMap<String, Integer> - key-value pairs with the N highest values
     *                                    and their keys
     */

    int[] highestValues = getNHighestValues(toBeFiltered, nHighest);
    HashMap<String, Integer> highestKeys = new HashMap<>();

    for (Map.Entry<String, Integer> myIter : toBeFiltered.entrySet()) {
      boolean isIn = IntStream.of(highestValues).anyMatch(x -> x == myIter.getValue());

      if (isIn) {
        highestKeys.put(myIter.getKey(), myIter.getValue());
      }
    }
    return filterToNItems(highestKeys, highestValues, nHighest);
  }

  private static int[] getNHighestValues(HashMap<String, Integer> numbersMap, int nHighest) {
    /**
     * This function generates an int[] with the N highest numbers in 'numbersMap'.
     *
     *
     * @param numbersMap   HashMap<String, Integer> - from which you would like to
     *                                                gather the N highest values
     * @param nHighest     int                      - the number of the highest values
     *
     * @return int[] with the N highest values of numbersMap parameter
     */

    int[] highestValues = new int[nHighest];

    for (int num : numbersMap.values()) {
      if (num > highestValues[0]) {
        highestValues[0] = num;
        Arrays.sort(highestValues);
      }
    }
    return highestValues;
  }

  private static String[] filterToNItems(
      HashMap<String, Integer> highestKeys,
      int[] highestValues,
      int n) {
    /**
     * This function reduces the number of items in highestKeys parameter according to
     *  the highestValues parameter (which should be the 'n' top numbers of the highestKeys'
     *  parameter).
     *
     *
     * @param highestKeys     HashMap<String, Integer> - to be filtered to n keys
     * @param highestValues   int[]                    - the n highest values of the
     *                                                   first parameter
     * @param n               int                      - number of leftover keys
     *                                                   related to highest values
     *
     * @return HashMap<String, Integer> - key-value pairs with the highest values
     *                                    and their keys
     */

    Arrays.sort(highestValues);
    for (int i = 0; i < n; i++) {
      while (highestKeys.size() > n) {
        for (Map.Entry<String, Integer> myIter : highestKeys.entrySet()) {
          if (myIter.getValue() == highestValues[i]) {
            highestKeys.remove(myIter.getKey());
            break;
          }
        }
      }
    }
    return highestKeys.keySet().toArray(new String[0]);
  }
}