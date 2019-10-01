package fleetofthings;

import printable.Printable;

/**
 * Created by aze on 2017.03.29..
 */
public class Thing implements Comparable<Thing>, Printable {

  private String name;
  private boolean completed;

  public Thing(String name) {
    this.name = name;
  }

  public void complete() {
    this.completed = true;
  }

  @Override
  public String toString() {
    return (completed ? "[x] " : "[ ] ") + name;
  }

  @Override
  public int compareTo(Thing thing) {
    if (thing.toString().equals(thing.toString())) {
      return (this.completed == thing.completed ? 0 : (this.completed) ? 1 : -1);
    } else {
      return this.toString().compareTo(thing.toString());
    }
  }

  @Override
  public void printAllFields() {
    System.out.println(this);
  }
}