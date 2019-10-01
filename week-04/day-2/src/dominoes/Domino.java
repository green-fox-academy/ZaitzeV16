package dominoes;

import printable.Printable;

public class Domino implements Comparable<Domino>, Printable {

  private final int left;
  private final int right;

  public Domino(int left, int right) {
    this.left = left;
    this.right = right;
  }

  public int getLeftSide() {
    return left;
  }

  public int getRightSide() {
    return right;
  }

  @Override
  public String toString() {
    return "[" + left + ", " + right + "]";
  }

  @Override
  public int compareTo(Domino domino) {
    if (this.getLeftSide() == domino.getLeftSide()) {
      return this.getRightSide() - domino.getRightSide();
    } else {
      return this.getLeftSide() - domino.getLeftSide();
    }
  }

  @Override
  public void printAllFields() {
    System.out.println(this);
  }
}