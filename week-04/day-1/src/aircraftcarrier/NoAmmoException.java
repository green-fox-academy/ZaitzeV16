package aircraftcarrier;

public class NoAmmoException extends Exception {

  public NoAmmoException() {
    super("No ammo left!");
  }
}
