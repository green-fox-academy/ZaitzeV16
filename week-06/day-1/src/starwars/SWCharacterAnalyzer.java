package starwars;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SWCharacterAnalyzer {

  public static void main(String[] args) {
    /*
    The swcharacters.csv file contains the list of characters appeared in the Star Wars universe.

    > "BBY" stands for Before the Battle of Yavin, it's the "year zero" in the
    > Galactic Standard Calendar. For the age calculation let's assume that it's
    > "year zero" and every character lives for the sake of simplicity.

    Create Stream expressions to perform the following exercises:`
     */

    // load file
    Map<String, String[]> sWCharacters = new HashMap<>();
    BufferedReader br;

    try {
      br =
          new BufferedReader(
              new InputStreamReader(
                  new FileInputStream(
                      new File("src/starwars/swcharacters.csv"))));
      sWCharacters = br.lines()
          .skip(
              1)  //skip header- name;height;mass;hair_color;skin_color;eye_color;birth_year;gender
          .collect(Collectors.toMap(
              character -> character.split(";")[0],
              character -> character.split(";")
          ));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    // - Print the name of the heaviest character (if the mass is unknown, ignore that character)
    String nameOfHeaviest = sWCharacters
        .entrySet()
        .stream()
        .filter(item -> item.getValue()[2]
            .chars()
            .allMatch(Character::isDigit))
        .collect(Collectors.toMap(
            Entry::getKey,
            item -> Integer.parseInt(item.getValue()[2])
        ))
        .entrySet()
        .stream()
        .sorted(Collections.reverseOrder(Entry.comparingByValue()))
        .limit(1)
        .collect(Collectors.toList())
        .get(0)
        .getKey();
    System.out.println("Name of the heaviest character: " + nameOfHeaviest);

    // - Print the average height of the male characters
    double avgHeightOfMales = sWCharacters
        .values()
        .stream()
        .filter(strings -> "male".equals(strings[7]))
        .filter(strings -> strings[1]
            .chars()
            .allMatch(Character::isDigit))
        .mapToDouble(strings -> Double.parseDouble(strings[1]))
        .average()
        .orElse(-1);
    System.out.println("Average height of the male characters: " + avgHeightOfMales);

    // - Print the average height of the female characters
    double avgHeightOfFemales = sWCharacters
        .values()
        .stream()
        .filter(strings -> "female".equals(strings[7]))
        .filter(strings -> strings[1]
            .chars()
            .allMatch(Character::isDigit))
        .mapToDouble(strings -> Double.parseDouble(strings[1]))
        .average()
        .orElse(-1);
    System.out.println("Average height of the female characters: " + avgHeightOfFemales);
    System.out.println("===================================");

    /*
    - 💪 Get the age distribution of the characters by gender (where the gender can
      be "male", "female" and "other")
      - The age groups are: "below 21", "between 21 and 40", "above 40" and
        "unknown"
      - The result should be a Map<String, Map<String, Integer>>
     */
    List<String> wantedGenders = List.of("male", "female", "other");
    List<String> ageGroups = List.of("below 21", "between 21 and 40", "above 40", "unknown");

    Map<String, Map<String, Long>> partialResult =
        sWCharacters
            .values()
            .stream()
            .collect(Collectors.groupingBy(
                item -> item[7],
                Collectors.groupingBy(
                    subItem -> subItem[6].replace("BBY", ""),
                    Collectors.counting()
                )));
    System.out.println(partialResult);
  }
}
