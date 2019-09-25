package pirates;

import java.util.Random;

public class Pirate {

  /*
    Create a `Pirate` class.  While you can add other fields and methods,
      you must have these methods:-
    - `drinkSomeRum()` - intoxicates the Pirate some
    - `howsItGoingMate()` - when called, the Pirate replies, if `drinkSomeRun` was called:-
      - 0 to 4 times, "Pour me anudder!"
      - else, "Arghh, I'ma Pirate. How d'ya d'ink its goin?",
        the pirate passes out and sleeps it off.
   */

  /*
    If you manage to get this far, then you can try to do the following.
    - `die()` - this kills off the pirate, in which case, drinkSomeRum, etc.
        just result in `he's dead`.
    - `brawl(x)` - where pirate fights another pirate (if that other pirate is alive)
        and there's a 1/3 chance, 1 dies, the other dies or they both pass out.
   */

  // instance fields
  int intoxication;
  boolean isDead = false;
  boolean isPassedOut = false;
  Parrot parrot;


  // constructors
  public Pirate() {
    this(0);
  }

  public Pirate(int parrotNumber) {
    Random random = new Random();

    this.parrot = new Parrot("Gyurrika" + parrotNumber, this);
    this.intoxication = random.nextInt(15);
  }

  // functions
  public void drinkSomeRum() {
    if (!this.isDead) {
      this.intoxication++;
    } else {
      System.out.println("he's dead");
    }
  }

  public void howsItGoingMate() {
    if (!this.isDead) {
      if (this.intoxication <= 4) {
        System.out.println("Pour me anudder!");
      } else {
        System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
        this.isPassedOut = true;
      }
    } else {
      System.out.println("he's dead");
    }
  }

  public void die() {
    if (!this.isDead) {
      this.isDead = true;
    } else {
      System.out.println("he's dead");
    }
  }

  public Pirate brawl(Pirate enemyPirate) {
    if ((this.isDead || this.isPassedOut) &&
        !(enemyPirate.isDead && enemyPirate.isPassedOut)) {
      this.isDead = true;
    }

    if ((enemyPirate.isDead || enemyPirate.isPassedOut) &&
        !(this.isDead && this.isPassedOut)) {
      System.out.println("Yaarrrrrrrrrrrr!");
      enemyPirate.isDead = true;
    } else {
      double result = Math.random();

      if (result < 0.333) {
        this.isDead = true;
      } else if (0.333 < result && result < 0.666) {
        enemyPirate.isDead = true;
      } else {
        enemyPirate.isPassedOut = true;
        this.isPassedOut = true;
      }
    }
    return enemyPirate;
  }
}
