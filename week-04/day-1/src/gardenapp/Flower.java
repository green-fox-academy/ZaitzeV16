package gardenapp;

public class Flower extends Plant {
  /*
  The Flower
  needs water if its current water amount is less then 5
  when watering it the flower can only absorb the 75% of the water
  eg. watering with 10 the flower's amount of water should only increase with 7.5
   */

  // constructors
  public Flower(String color) {
    super(color);
    this.setAbsorbRate(3. / 4);
    this.setCurrentWaterAmount(0);
    this.setMaxWaterAmount(5);
  }
}
