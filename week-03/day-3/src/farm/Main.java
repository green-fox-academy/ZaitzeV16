package farm;

public class Main {

  public static void main(String[] args) {
    /*
    #### Farm
    - Reuse your `Animal` class
    - Create a `Farm` class
      - it has list of Animals
      - it has slots which defines the number of free places for animals
      - breed() -> creates a new animal if there's place for it
      - slaughter() -> removes the least hungry animal
     */
    Farm farm = new Farm(4, 10);
    System.out.println(farm.animals.size());

    farm.breed();
    System.out.println("free slots " + farm.freeSlots);
    System.out.println(farm.animals.size());

    farm.slaughter();
    farm.slaughter();
    farm.slaughter();
    System.out.println(farm.animals.size());
    System.out.println("free slots " + farm.freeSlots);
  }
}
