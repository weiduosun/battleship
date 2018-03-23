package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

/**
 * .
 * represent a destroyer
 */

public class Destroyer extends AbstractShip {

  private static final int DESTROYER_SIZE = 1;

  /**
   * .
   * constructor of destroyer
   */

  public Destroyer() {
    super(DESTROYER_SIZE, 0);
  }

  /**
   * .
   * constructor of destroyer
   *
   * @param size    size of the ship
   * @param hitCell the number of cells got hit
   */

  public Destroyer(Integer size, Integer hitCell) {
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
    return "Destroyer{"
        + "size=" + this.getShipSize()
        + ", hitCell=" + this.getNumHitCells()
        + '}';
  }
}
