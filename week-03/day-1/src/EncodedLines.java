import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class EncodedLines {

  public static void main(String[] args) {
    // Create a method that decrypts encoded-lines.txt

    // the encryption is Caesar cypher
    HashMap<String, Integer> charMapByChar = createCharMapByChar();
    HashMap<Integer, String> charMapByValue = createCharMapByPlace();

    int offsetFrom = -1;
    int offsetTo = 0;

    decodeMsg(charMapByChar, charMapByValue, offsetFrom, offsetTo);
  }

  private static void decodeMsg(
      HashMap<String, Integer> charMapByChar,
      HashMap<Integer, String> charMapByValue,
      int offsetFrom, int offsetTo) {
    /**
     * This function decrypts Caesar cypher.
     *
     *
     * @param charMapByChar   HashMap<String, Integer> - 'character': 'ACSII value'
     *
     * @param charMapByValue  HashMap<Integer, String> - 'ACSII value': 'character'
     *
     * @param offsetFrom      int                      - decoding from
     *                                                  'ACSII value' + offsetFrom
     *
     * @param offsetTo        int                      - decoding to
     *                                                  'ACSII value' + offsetTo
     */

    // open file and get content
    Path path = Paths.get("./encoded-lines.txt");
    ArrayList<String> content = Doubled.getFileContent(path);

    // initiate stringBuilder
    StringBuilder stringBuilder = new StringBuilder();

    // separate every character
    ArrayList<String[]> contentByChar = new ArrayList<>();
    for (String line : content) {
      contentByChar.add(line.split(""));
    }

    // set lowest and highest Ascii value for later use
    int minAscii = Collections.min(charMapByChar.values());
    int maxAscii = Collections.max(charMapByChar.values());

    // iterate - from: offsetFrom to: offsetTo
    for (int i = offsetFrom; i < offsetTo; i++) {
      // iterate - lines
      for (String[] line : contentByChar) {
        // iterate - characters
        for (String currChar : line) {

          // if char is empty, skip to next iteration (character)
          // else if current char is whitespace, append and continue
          // else go on with iteration
          if ("".equals(currChar)) {
            continue;
          } else if (currChar.trim().length() == 0) {
            stringBuilder.append(currChar);
            continue;
          }

          // if we did one cycle according to the ASCII char map, start from the
          // beginning of the charmap
          boolean contains = charMapByValue.containsKey(charMapByChar.get(currChar) + i);
          String charToAppend;
          if (contains) {
            charToAppend = charMapByValue.get(charMapByChar.get(currChar) + i);
          } else {
            int key = minAscii + ((charMapByChar.get(currChar) + i) - maxAscii);
            charToAppend = charMapByValue.get(key);
          }
          // append new character to the stringbuilder
          stringBuilder.append(charToAppend);
        }
        // append new line to the stringbuilder
        stringBuilder.append("\n");
      }
    }
    System.out.println(stringBuilder.toString());
  }

  private static HashMap<String, Integer> createCharMapByChar() {
    /**
     * This function creates a 'character': 'ACSII value' hashmap.
     *
     * @return HashMap<String, Integer> - 'character': 'ACSII value'
     */

    HashMap<String, Integer> resultByChar = new HashMap<>();

    for (int asciiInt = 32; asciiInt < 128; asciiInt++) {
      // System.out.println(asciiInt + ": " + (char) asciiInt);
      resultByChar.put(String.valueOf((char) asciiInt), asciiInt);
    }
    return resultByChar;
  }

  private static HashMap<Integer, String> createCharMapByPlace() {
    /**
     * This function creates an 'ACSII value': 'character' hashmap.
     *
     * @return HashMap<Integer, String> - 'ACSII value': 'character'
     */

    HashMap<Integer, String> resultByPlace = new HashMap<>();

    for (int asciiInt = 32; asciiInt < 128; asciiInt++) {
      // System.out.println(asciiInt + ": " + (char) asciiInt);
      resultByPlace.put(asciiInt, String.valueOf((char) asciiInt));
    }
    return resultByPlace;
  }
}