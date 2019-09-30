package aircraftcarrier;

public class Jet {

  /*
  ### F16
  - Max ammo: 8
  - Base damage: 30

  ### F35
  - Max ammo: 12
  - Base damage: 50

  All aircrafts should be created with an empty ammo storage

   */
  // private fields
  private int maxAmmo;
  private int currentAmmo;

  private int baseDamage;
  private int damageDealt;

  private String type;
  private boolean isPriority;

  // constructors
  public Jet() {
    this.currentAmmo = 0;
    this.damageDealt = 0;
  }

  public Jet(int maxAmmo, int baseDamage, String type, boolean isPriority) {
    this();
    this.maxAmmo = maxAmmo;
    this.baseDamage = baseDamage;
    this.type = type;
    this.isPriority = isPriority;
  }

  // methods
  public int fight() {
    /**
     *   #### fight
     *   - It should use all the ammo (set it to 0) and it should return the damage it
     *     deals
     *   - The damage dealt is calculated by multiplying the base damage by the
     *     ammunition
     */
    int damageDealt = this.baseDamage * this.currentAmmo;
    this.damageDealt = damageDealt;
    this.currentAmmo = 0;

    return damageDealt;
  }

  public int refillAmmo(int ammo) {
    /**
     *   #### refill
     *   - It should take a number as parameter and subtract as much ammo as possible
     *   - It can't have more ammo than the number or the max ammo (can't get more ammo
     *     than what's coming from the parameter or the max ammo of the aircraft)
     *   - It should return the remaining ammo
     *   - Eg. Filling an empty F35 with `300` would completely fill the storage of the
     *     aircraft and would return the remaining `288`
     */
    if (this.currentAmmo == this.maxAmmo) {
      // at max ammo
      return ammo;
    } else if (ammo < this.maxAmmo - this.currentAmmo) {
      // ammo is not enough to fill to max
      this.currentAmmo += ammo;
      return 0;
    } else {
      // ammo is more than needed
      int lefOverAmmo = ammo - (this.maxAmmo - this.currentAmmo);
      this.currentAmmo = this.maxAmmo;
      return lefOverAmmo;
    }
  }

  public boolean needsAmmo() {
    return this.currentAmmo < this.maxAmmo;
  }

  public int ammoNeeded() {
    return (this.needsAmmo()) ? this.maxAmmo - this.currentAmmo : 0;
  }


  // getters, setters
  public String getType() {
    /**
     *   #### getType
     *   - It should return the type of the aircraft as a string
     */
    return this.type;
  }

  public String getStatus() {
    /**
     *   #### getStatus
     *   - It should return a string like:
     *     `Type F35, Ammo: 10, Base Damage: 50, All Damage: 500`
     */
    String[] jetStatus = {
        "Type: " + this.type,
        "Ammo: " + this.currentAmmo,
        "Base Damage: " + this.baseDamage,
        "All Damage: " + this.damageDealt,
    };
    return String.join(", ", jetStatus);
  }

  public boolean isPriority() {
    /**
     *   #### isPriority
     *   - It should return if the aircraft is priority in the ammo fill queue. It's
     *     `true` for F35 and `false` for F16
     */
    return this.isPriority;
  }

  public int getDamageDone() {
    return damageDealt;
  }
}
