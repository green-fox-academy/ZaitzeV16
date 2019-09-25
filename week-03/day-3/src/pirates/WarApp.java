package pirates;

public class WarApp {

  public static void main(String[] args) {
    // Ain't the best, but works
    //                          - Z

    /*
    ## WarApp
    - Create a `WarApp` class with a `main` method
    - Create 2 armadas, fill them with ships
    - Have a war!
     */
    Armada meArmada = new Armada("genyó");
    meArmada.recruitArmada();
    System.out.println(meArmada.toString());

    Armada enemyArmada = new Armada("enemygenyó");
    enemyArmada.recruitArmada();
    System.out.println(enemyArmada.toString());

    System.out.println(meArmada.war(enemyArmada));
  }
}
