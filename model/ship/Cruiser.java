package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

/**
 * .
 * represent a cruiser
 */

public class Cruiser extends AbstractShip {

  private static final int CRUISER_SIZE = 3;

  /**
   * .
   * constructor of cruiser
   */


  public Cruiser() {
    super(CRUISER_SIZE, 0);
  }

  /**
   * .
   * constructor of cruiser
   *
   * @param size    size of the ship
   * @param hitCell the number of cells got hit
   */

  public Cruiser(Integer size, Integer hitCell) {
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
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
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
    return "Cruiser{" + "size=" + this.getShipSize()
        + ", hitCell=" + this.getNumHitCells()
        + '}';
  }
}
