package pirates;

public class BattleApp {

  public static void main(String[] args) {
    /*
    ## BattleApp
    - Create a `BattleApp` class with a `main` method
    - Create 2 ships, fill them with pirates
    - Have a battle!
     */

    Ship meShip = new Ship(42);
//    System.out.println(meShip.toString());
    meShip.fillShip();
//    System.out.println();
    System.out.println(meShip.toString());

//    meShip.captain.die();
//    meShip.captain.drinkSomeRum();
//    meShip.captain.howsItGoingMate();
//    meShip.captain.parrot.talk();

    System.out.println("===========================================");
    System.out.println("===========================================");
    System.out.println("===========================================");
    Ship enemyShip = new Ship(69);
    enemyShip.fillShip();
    System.out.println(enemyShip.toString());

    System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
    boolean weWon = meShip.battle(enemyShip);
    System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
    System.out.println(weWon);
    System.out.println();

    System.out.println("===========================================");
    System.out.println("===========================================");
    System.out.println("===========================================");
  }
}
