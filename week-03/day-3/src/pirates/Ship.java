package pirates;

import java.util.ArrayList;
import java.util.Random;

public class Ship {
  /*
  # The Pirate Ship
  *The place for the Pirates*

  - Create a `Ship` class.
  - The `Ship` stores `Pirate`-s instances in a list as the crew and
    has one captain who is also a `Pirate`.
  - When a ship is created it doesn't have a crew or a captain.
   */

  Pirate captain;
  ArrayList<Pirate> crew = new ArrayList<>();

  // constructors
  public Ship() {
    this(42);
  }

  public Ship(int parrotNumber) {
    this.captain = new Pirate(parrotNumber);
  }

  // functions
  public void fillShip() {
    /*
    - The ship can be filled with pirates and a captain via `fillShip()` method.
        - Filling the ship with a captain and random number of pirates.
    */

    Random random = new Random();

    for (int i = 1; i < random.nextInt(50) + 30; i++) {
      this.crew.add(new Pirate(i));
    }
  }

  public boolean battle(Ship enemy) {
    /*
    - Ships should have a method to battle other ships: `ship.battle(otherShip)`
        - should return `true` if the actual ship (`this`) wins
        - the ship should win if its calculated score is higher
        - calculate score: Number of Alive pirates in the crew -
          Number of consumed rum by the captain
        - The loser crew has a random number of losses (deaths).
        - The winner captain and crew has a party, including a random number of rum :)
     */
    boolean victory = this.calculateBattle(enemy);
    Ship loser = (victory) ? enemy : this;

    Random random = new Random();
    int numberOfDeaths = random.nextInt(loser.crew.size());

    // announce result
    battleAnnouncement(victory, numberOfDeaths);

    for (Pirate loserCrewMember : loser.crew) {
      loserCrewMember.isDead = true;
      numberOfDeaths--;
      if (numberOfDeaths <= 0) {
        break;
      }
    }

    int raidedRum = random.nextInt(enemy.crew.size());
    this.letsParty(raidedRum);

    return victory;
  }

  // private methods
  private boolean calculateBattle(Ship enemyShip) {
    int selfScore = 0;
    int enemyScore = 0;

    // our score
    for (Pirate crewMember : this.crew) {
      if (!(crewMember.isDead && crewMember.isPassedOut)) {
        selfScore++;
      }
    }
    selfScore -= this.captain.intoxication;

    // enemy score
    for (Pirate enemyCrewMember : enemyShip.crew) {
      if (!(enemyCrewMember.isDead && enemyCrewMember.isPassedOut)) {
        enemyScore++;
      }
    }
    enemyScore -= enemyShip.captain.intoxication;

    if (selfScore >= enemyScore) {
      return true;
    } else {
      return false;
    }
  }

  private void battleAnnouncement(boolean weWon, int deaths) {
    if (weWon) {
      System.out.println("Yaarrrrrrrrrrrrrrrrrrrr!!!");
      System.out.println("Enemy crew has been fed to sharks!");
      System.out.println("Rum consumers they lost: " + deaths);
    } else {
      System.out.println("LOST neeed... more.... rum...");
      System.out.println("Rum consumers they lost: " + deaths);
      System.out.println("Ain't no body got time for that...");
    }
  }

  private void letsParty(int raidedRum) {
    System.out.println("We raided the opponent ship and got ");
    System.out.println(raidedRum + " bottles of rum");
    System.out.println("Yaarrrr to the capitan!!");
  }

  // overrides
  @Override
  public String toString() {
    /*
    - Ships should be represented in a nice way on command line including
      information about
        - captains consumed rum, state (passed out / died)
        - number of alive pirates in the crew
     */
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append("The captain's parrot's name is: ");
    stringBuilder.append(this.captain.parrot.name);
    stringBuilder.append(".");
    stringBuilder.append("\n");

    stringBuilder.append("The captain consumed rum ");
    stringBuilder.append(this.captain.intoxication);
    stringBuilder.append(" times.");
    stringBuilder.append("\n");

    stringBuilder.append("The captain is currently ");
    if (this.captain.isDead) {
      stringBuilder.append("dead.");
    } else if (this.captain.isPassedOut) {
      stringBuilder.append("passed out.");
    } else {
      stringBuilder.append("being a pirate.");
    }
    stringBuilder.append("\n");

    int alivePirates = 0;
    int awakePirates = 0;
    int deadPirates = 0;

    int totalRumConsumed = 0;
    for (Pirate pirate : this.crew) {
      if (!pirate.isDead) {
        if (!pirate.isPassedOut) {
          alivePirates++;
          awakePirates++;
        } else {
          alivePirates++;
        }
      } else {
        deadPirates++;
      }
      totalRumConsumed += pirate.intoxication;
    }

    stringBuilder.append("===============================");
    stringBuilder.append("\n");

    stringBuilder.append("There are currently \n");
    stringBuilder.append("\t" + alivePirates + " pirates left\n");
    stringBuilder.append("\t" + awakePirates + " awake pirates\n");
    stringBuilder.append("\t" + deadPirates + " pirates died due to rum consumption\n");
    stringBuilder.append("...they'v consumed " + totalRumConsumed + " bottles of rum\n");

    return stringBuilder.toString();
  }
}
