package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

/**
 * .
 * represent a model
 */

public class Battleship extends AbstractShip {

  private static final int BATTLESHIP_SIZE = 4;

  /**
   * .
   * constructor of model
   */

  public Battleship() {
    super(BATTLESHIP_SIZE, 0);
  }

  /**
   * .
   * constructor of model
   *
   * @param size         size of the ship
   * @param numOfHitCell the number of cells got hit
   */

  public Battleship(Integer size, Integer numOfHitCell) {
    super(size, numOfHitCell);
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
    return "BattleShip{" + "size=" + this.getShipSize()
        + ", hitCell=" + this.getNumHitCells() + '}';
  }
}
