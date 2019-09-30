package fleetofthings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    // compare - description and completed

    // 1. [ ] Get milk
    // 2. [ ] Remove the obstacles
    // 3. [x] Stand up
    // 4. [x] Eat lunch

    Thing milkThing = new Thing("Get milk");
    Thing obstaclesThing = new Thing("Remove the obstacle");
    Thing standThing = new Thing("Stand up");
    Thing eatThing = new Thing("Eat lunch");

    standThing.complete();
    eatThing.complete();

    List<Thing> todoList = new ArrayList<>();
    todoList.add(milkThing);
    todoList.add(eatThing);
    todoList.add(standThing);
    todoList.add(obstaclesThing);

    System.out.println(todoList.toString());
    Collections.sort(todoList);
    System.out.println(todoList.toString());
  }
}
