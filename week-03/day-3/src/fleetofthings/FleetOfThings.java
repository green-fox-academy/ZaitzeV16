package fleetofthings;

public class FleetOfThings {

  public static void main(String[] args) {
    Fleet fleet = new Fleet();
    // - You have the `Thing` class
    // - You have the `Fleet` class
    // - You have the `FleetOfThings` class with a `main` method
    // - Download those, use those
    // - In the main method create a fleet
    // - Achieve this output:
    // Create a fleet of things to have this output:
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

    fleet.add(milkThing);
    fleet.add(obstaclesThing);
    fleet.add(standThing);
    fleet.add(eatThing);

    System.out.println(fleet);
  }
}