package wiki;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WikiReader {

  public static void main(String[] args) {
    /*
    Find a random Wikipedia article and copy the contents to a txt file.

    Create a Stream expression which reads all text from this file, and prints the
    100 most common words in descending order. Keep in mind that the text contains
    punctuation characters which should be ignored. The result should be something
    like this:

    the: 131
    of: 74
    and: 48
    to: 45
    a: 43
    in: 43
    was: 30
    as: 21
    German: 18
    for: 16
    his: 15
    by: 13
    he: 11
    that: 11
     */

    String wikiContent = "";

    try {
      wikiContent = Files.readString(Paths.get("src/wiki/wiki.txt"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    Map<String, Long> result = Stream.of(wikiContent.split("\\W+"))
        .collect(Collectors.groupingBy(
            String::toLowerCase,
            Collectors.counting()))
        .entrySet().stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .limit(100)
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue
        ));

    result.entrySet().stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

  }
}
