package dominoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dominoes {

  public static void main(String[] args) {
    List<Domino> dominoes = initializeDominoes();
    // You have the list of Dominoes
    // Order them into one snake where the adjacent dominoes have
    //  the same numbers on their adjacent sides
    // eg: [2, 4], [4, 3], [3, 5] ...

    for (int iCurr = 0; iCurr < dominoes.size() - 2; iCurr++) {
      Domino currDomino = dominoes.get(iCurr);
      int currRight = currDomino.getRightSide();
      for (int iFrom = iCurr + 1; iFrom < dominoes.size(); iFrom++) {
        if (dominoes.get(iFrom).getLeftSide() == currRight) {
          Collections.swap(dominoes, iCurr + 1, iFrom);
          break;
        }
      }
    }
    System.out.println(dominoes);
  }

  static List<Domino> initializeDominoes() {
    List<Domino> dominoes = new ArrayList<>();
    dominoes.add(new Domino(5, 2));
    dominoes.add(new Domino(4, 6));
    dominoes.add(new Domino(1, 5));
    dominoes.add(new Domino(6, 7));
    dominoes.add(new Domino(2, 4));
    dominoes.add(new Domino(7, 1));
    return dominoes;
  }
}