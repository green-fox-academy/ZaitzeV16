package gardenapp;

public class Tree extends Plant {

  /*
  The Tree
  needs water if its current water amount is less then 10
  when watering it the tree can only absorb the 40% of the water
  eg. watering with 10 the tree's amount of water should only increase with 4
   */
  // constructors
  public Tree(String color) {
    super(color);
    this.setAbsorbRate(4. / 10);
    this.setCurrentWaterAmount(0);
    this.setMaxWaterAmount(10);
  }
}
