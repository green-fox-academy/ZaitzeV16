package gardenapp;

public class Plant {

  /*
  The Flower
  needs water if its current water amount is less then 5
  when watering it the flower can only absorb the 75% of the water
  eg. watering with 10 the flower's amount of water should only increase with 7.5

  The Tree
  needs water if its current water amount is less then 10
  when watering it the tree can only absorb the 40% of the water
  eg. watering with 10 the tree's amount of water should only increase with 4
   */
  // private fields
  private double currentWaterAmount;
  private int maxWaterAmount;
  private double absorbRate;
  private String color;

  // constructors
  public Plant() {

  }

  public Plant(String color) {
    this.color = color;
  }

  // public methods
  public boolean needsWater() {
    return this.currentWaterAmount < this.maxWaterAmount;
  }

  public void waterPlant(double water) {
    if (this.needsWater()) {
      this.currentWaterAmount += this.absorbRate * water;
    } else {
      System.out.println("This plant does not need watering!");
    }
  }

  // getters and setters
  public String getColor() {
    return color;
  }

  public void setCurrentWaterAmount(double currentWaterAmount) {
    this.currentWaterAmount = currentWaterAmount;
  }

  public void setMaxWaterAmount(int maxWaterAmount) {
    this.maxWaterAmount = maxWaterAmount;
  }

  public void setAbsorbRate(double absorbRate) {
    this.absorbRate = absorbRate;
  }
}
