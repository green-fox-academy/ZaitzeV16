package pirates;

import java.util.ArrayList;
import java.util.Random;

public class Armada {
  /*
  # Armada
  - Create an `Armada` class
  - Contains `Ship`-s as a list
   */

  ArrayList<Ship> ships = new ArrayList<>();
  String name;

  // constructors
  public Armada() {
    this("no-name");
  }

  public Armada(String name) {
    this.name = name;
  }

  // functions
  public void recruitArmada() {
    if (this.ships.size() == 0) {
      this.recruitShips();
      for (Ship ship : this.ships) {
        ship.fillShip();
      }
    }
  }

  public boolean war(Armada enemyArmada) {
    /*
    - Have a `armada.war(otherArmada)` method where two armada
      can engage in war
        - it should work like merge sort
        - first ship from the first armada battles the first of the other
        - the loser gets skipped so the next ship comes in
          play from that armada
        - whichever armada gets to the end of its ships loses the war
        - return `true` if `this` is the winner
    */
    int enemyStart = 0;
    boolean warResult = false;

    for (int i = 0; i < this.ships.size(); i++) {
      for (int j = enemyStart; j < enemyArmada.ships.size(); j++) {
        boolean weWon = this.ships.get(i).battle(enemyArmada.ships.get(j));
        System.out.println("\n");
        System.out.println("==============================================");
        System.out.println("==============================================");
        System.out.println("==============================================");
        System.out.println("\n");
        if (weWon) {
          enemyStart++;
        } else {
          break;
        }
      }
      if (enemyStart == enemyArmada.ships.size() - 1) {
        warResult = true;
        break;
      } else if (i == this.ships.size() - 1) {
        warResult = false;
        break;
      }
    }
    return warResult;
  }

  // private functions
  private void recruitShips() {
    Random random = new Random();

    for (int i = 1; i < random.nextInt(50) + 30; i++) {
      this.ships.add(new Ship(i));
    }
  }

  // overrides
  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    int overAllCrew = 0;
    int overAllConsumption = 0;

    for (Ship ship : this.ships) {
      overAllCrew += ship.crew.size();
      for (Pirate pirate : ship.crew) {
        overAllConsumption += pirate.intoxication;
      }
    }

    stringBuilder.append("Number of ships: " + this.ships.size() + "\n");
    stringBuilder.append("Armada leader: " + overAllConsumption + " bottles of rum!\n");
    stringBuilder.append("Number of the crew: " + overAllCrew + "\n");

    return stringBuilder.toString();
  }
}
