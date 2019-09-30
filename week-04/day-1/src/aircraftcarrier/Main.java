package aircraftcarrier;

public class Main {

  public static void main(String[] args) throws NoAmmoException {
    /*
    # Aircraft Carrier

    ## Aircrafts

    - Create a class that represents an aircraft
    - There are 2 types of aircrafts: `F16` and `F35`
    - Both aircrafts should keep track of their ammunition

    ### F16

    - Max ammo: 8
    - Base damage: 30

    ### F35

    - Max ammo: 12
    - Base damage: 50

    All aircrafts should be created with an empty ammo storage

    ### Methods

    #### fight

    - It should use all the ammo (set it to 0) and it should return the damage it
      deals
    - The damage dealt is calculated by multiplying the base damage by the
      ammunition

    #### refill

    - It should take a number as parameter and subtract as much ammo as possible
    - It can't have more ammo than the number or the max ammo (can't get more ammo
      than what's coming from the parameter or the max ammo of the aircraft)
    - It should return the remaining ammo
    - Eg. Filling an empty F35 with `300` would completely fill the storage of the
      aircraft and would return the remaining `288`

    #### getType

    - It should return the type of the aircraft as a string

    #### getStatus

    - It should return a string like:
      `Type F35, Ammo: 10, Base Damage: 50, All Damage: 500`

    #### isPriority

    - It should return if the aircraft is priority in the ammo fill queue. It's
      `true` for F35 and `false` for F16

    ## Carrier

    Create a class that represents an aircraft-carrier

    - The carrier should be able to store aircrafts
    - Each carrier should have a store of ammo represented as number
    - The initial ammo should be given by a parameter in its constructor
    - The carrier also has a health point given in its constructor as well

    ### Methods

    #### add

    - It should take a new aircraft and add it to its storage

    #### fill

    - It should fill all the aircraft with ammo and subtract the needed ammo from
      the ammo storage
    - If there is not enough ammo then it should start to fill the aircrafts with
      priority first
    - If there is no ammo when this method is called, it should throw an exception

    #### fight

    - It should take another carrier as a reference parameter and fire all the ammo
      from the aircrafts to it, then subtract all the damage from its health points

    #### getStatus

    It should return a string about itself and all of its aircrafts' statuses in the
    following format:

    ```text
    HP: 5000, Aircraft count: 5, Ammo Storage: 2300, Total damage: 2280
    Aircrafts:
    Type F35, Ammo: 12, Base Damage: 50, All Damage: 600
    Type F35, Ammo: 12, Base Damage: 50, All Damage: 600
    Type F35, Ammo: 12, Base Damage: 50, All Damage: 600
    Type F16, Ammo: 8, Base Damage: 30, All Damage: 240
    Type F16, Ammo: 8, Base Damage: 30, All Damage: 240
    ```

    If the health points are 0 then it should return: `It's dead Jim :(`
     */

//    F16 f16 = new F16();
//    System.out.println(f16.getStatus());
//    System.out.println(f16.refillAmmo(500));
//    System.out.println(f16.getStatus());
//
//    System.out.println("=================================");
//
//    F35 f35 = new F35();
//    System.out.println(f35.getStatus());
//    System.out.println(f35.refillAmmo(3));
//    System.out.println(f35.getStatus());
//
//    System.out.println("=================================");

    Carrier carrier = new Carrier(150, 5000);
    for (int i = 0; i < 5; i++) {
      carrier.add(new F16());
      carrier.add(new F35());
    }
    System.out.println(carrier.getStatus());

    System.out.println("=================================");

    Carrier enemyCarrier = new Carrier(2222, 5000);
    for (int i = 0; i < 5; i++) {
      enemyCarrier.add(new F16());
      enemyCarrier.add(new F35());
    }
    System.out.println(enemyCarrier.getStatus());

    System.out.println("=================================");

    carrier.fill();
    carrier.fight(enemyCarrier);
//    System.out.println(carrier.getStatus());
    System.out.println("---------------------------------");
    System.out.println(enemyCarrier.getStatus());

    System.out.println("=================================");
    carrier.fill();
    carrier.fight(enemyCarrier);
    System.out.println("---------------------------------");
    System.out.println(enemyCarrier.getStatus());

    System.out.println("=================================");
    System.out.println(carrier.getStatus());
  }
}
