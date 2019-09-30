package aircraftcarrier;

import java.util.ArrayList;
import java.util.List;

public class Carrier {

  /*
  ## Carrier

  Create a class that represents an aircraft-carrier

  - The carrier should be able to store aircrafts
  - Each carrier should have a store of ammo represented as number
  - The initial ammo should be given by a parameter in its constructor
  - The carrier also has a health point given in its constructor as well
   */
  // fields
  private List<Jet> aircrafts;
  private int ammoStorage;
  private int health;

  // constructors
  public Carrier(int initialAmmo, int health) {
    this.aircrafts = new ArrayList<>();
    this.ammoStorage = initialAmmo;
    this.health = health;
  }


  // methods
  public void add(Jet jet) {
    /**
     *   #### add
     *
     *   - It should take a new aircraft and add it to its storage
     */
    this.aircrafts.add(jet);
  }

  public void fill() throws NoAmmoException {
    /**
     *   #### fill
     *
     *   - It should fill all the aircraft with ammo and subtract the needed ammo from
     *     the ammo storage
     *   - If there is not enough ammo then it should start to fill the aircrafts with
     *     priority first
     *   - If there is no ammo when this method is called, it should throw an exception
     */
    if (this.ammoStorage <= 0) {
      throw new NoAmmoException();
    } else {
      int ammoNeeded = overallAmmoNeeded();

      if (this.ammoStorage < ammoNeeded) {
        // fill priority jets
        for (Jet jet : this.aircrafts) {
          if (jet.isPriority() && jet.needsAmmo()) {
            this.ammoStorage = jet.refillAmmo(this.ammoStorage);
          }
        }

        // fill non-priority jets
        // if still has ammo
        if (this.ammoStorage > 0) {
          for (Jet jet : this.aircrafts) {
            if (jet.needsAmmo()) {
              this.ammoStorage = jet.refillAmmo(this.ammoStorage);
            }
          }
        }
      } else {
        for (Jet jet : this.aircrafts) {
          if (jet.needsAmmo()) {
            this.ammoStorage = jet.refillAmmo(this.ammoStorage);
          }
        }
      }
    }
  }

  public int overallAmmoNeeded() {
    int ammoNeeded = 0;
    for (Jet jet : this.aircrafts) {
      ammoNeeded += jet.ammoNeeded();
    }

    return ammoNeeded;
  }

  public void fight(Carrier enemyCarrier) {
    /**
     *   #### fight
     *
     *   - It should take another carrier as a reference parameter and fire all the ammo
     *     from the aircrafts to it, then subtract all the damage from its health points
     */

    for (Jet jet : this.aircrafts) {
      enemyCarrier.setHealth(enemyCarrier.getHealth() - jet.fight());
      if (enemyCarrier.getHealth() <= 0) {
        enemyCarrier.setHealth(0);
        break;
      }
    }
  }

  public String getStatus() {
    /**
     *   #### getStatus
     *
     *   It should return a string about itself and all of its aircrafts' statuses in the
     *   following format:
     *
     *   ```text
     *   HP: 5000, Aircraft count: 5, Ammo Storage: 2300, Total damage: 2280
     *   Aircrafts:
     *   Type F35, Ammo: 12, Base Damage: 50, All Damage: 600
     *   Type F35, Ammo: 12, Base Damage: 50, All Damage: 600
     *   Type F35, Ammo: 12, Base Damage: 50, All Damage: 600
     *   Type F16, Ammo: 8, Base Damage: 30, All Damage: 240
     *   Type F16, Ammo: 8, Base Damage: 30, All Damage: 240
     *   ```
     *
     *   If the health points are 0 then it should return: `It's dead Jim :(`
     */

    if (this.health > 0) {
      StringBuilder stringBuilder = new StringBuilder();

      String[] carrierSelfStatus = {
          "HP: " + this.health,
          "Aircraft count: " + this.aircrafts.size(),
          "Ammo Storage: " + this.ammoStorage,
          "Total damage: " + this.getAllDamageDone(),
      };
      stringBuilder.append(String.join(", ", carrierSelfStatus));
      stringBuilder.append("\nAircrafts:");

      List<String> jetStatus = new ArrayList<>();
      for (Jet jet : this.aircrafts) {
        jetStatus.add("\n");
        jetStatus.add(jet.getStatus());
      }
      stringBuilder.append(String.join("", jetStatus));

      return stringBuilder.toString();
    } else {
      return "It's dead Jim :(";
    }
  }

  private int getAllDamageDone() {
    int allDamageDone = 0;
    for (Jet jet : this.aircrafts) {
      allDamageDone += jet.getDamageDone();
    }
    return allDamageDone;
  }

  // getters and setter
  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }
}
