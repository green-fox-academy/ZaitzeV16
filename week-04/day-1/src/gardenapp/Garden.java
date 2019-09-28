package gardenapp;

import java.util.ArrayList;
import java.util.List;

public class Garden {

  /*
  - The Garden
    - is able to hold unlimited amount of flowers or trees
    - when watering it should only water those what needs water with equally
      divided amount amongst them
    - eg. watering with 40 and 4 of them need water then each gets watered with 10
   */
  // fields
  private List<Plant> plants;

  // constructors
  public Garden() {
    this.plants = new ArrayList<>();
  }

  // public methods
  public void addPlant(Plant plant) {
    this.plants.add(plant);
  }

  public void waterPlants(int sumWater) {
    System.out.println("Watering with " + sumWater);

    List<Plant> toBeWatered = new ArrayList<>();
    for (Plant plant : this.plants) {
      if (plant.needsWater()) {
        toBeWatered.add(plant);
      }
    }

    double waterEach = ((double) sumWater) / toBeWatered.size();

    for (Plant plant : toBeWatered) {
      plant.waterPlant(waterEach);
    }

    showGarden();
  }

  public void showGarden() {
    for (Plant plant : this.plants) {
      String simpleName = plant.getClass().getSimpleName();
      String needsWater = (plant.needsWater()) ? "needs water!" : "doesn't need water.";
      System.out.println("The " + plant.getColor() + " " + simpleName + " " + needsWater);
    }
  }
}
