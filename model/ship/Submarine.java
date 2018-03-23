package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

/**
 * .
 * represent a submarine
 */

public class Submarine extends AbstractShip {

  private static final int SUBMARINE_SIZE = 2;

  /**
   * .
   * constructor of submarine
   */

  public Submarine() {
    super(SUBMARINE_SIZE, 0);
  }

  /**
   * .
   * constructor of submarine
   *
   * @param size    size of the ship
   * @param hitCell the number of cells got hit
   */

  public Submarine(Integer size, Integer hitCell) {
    super(size, hitCell);
  }

  /**
   * .
   * compare object with instance of this class
   *
   * @param object the object to be compared with specific instance of this class
   * @return true if the two object are the same, false otherwise
   */

  @Override
  public boolean equals(Object object) {

    return super.equals(object);
  }

  /**
   * .
   * calculate hash code
   *
   * @return hash code value of specific instance of this class
   */

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * .
   * represent information in this object as a string
   *
   * @return string to represent the information in this object
   */

  @Override
  public String toString() {
    return "Submarine{"
        + "size=" + this.getShipSize()
        + ", hitCell=" + this.getNumHitCells()
        + '}';
  }
}
