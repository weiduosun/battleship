package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;


import java.util.Objects;

/**
 * .
 * represent a abstractship
 */

public abstract class AbstractShip implements Ship {
  private Integer size;
  private Integer numHitCells;

  /**
   * .
   * constructor of abstactship
   *
   * @param size   the size of the ship
   * @param number the number of cells got hit
   */

  public AbstractShip(Integer size, Integer number) {
    this.size = size;
    this.numHitCells = number;
  }

  /**
   * .
   * the size of the ship
   *
   * @return the size of the ship
   */

  public Integer getShipSize() {
    return this.size;
  }

  /**
   * .
   * the number of cells got hit
   *
   * @return the number of cells got hit
   */

  public Integer getNumHitCells() {
    return this.numHitCells;
  }

  /**
   * .
   * change size of the ship
   */


  public void setSize(Integer size) {
    this.size = size;
  }

  /**
   * .
   * change the number of hit cells of the ship
   */

  public void setNumHitCells(Integer numHitCells) {
    this.numHitCells = numHitCells;
  }

  /**
   * .
   * update number of hit cells , increase by 1
   */

  public void updateHitCell() {
    this.setNumHitCells(this.getNumHitCells() + 1);
  }

  /**
   * .
   * check if the ship is isCellSunk
   *
   * @return true if it is, false otherwise
   */

  @Override
  public Boolean isShipSunk() {
    return this.size.equals(this.numHitCells);
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
    AbstractShip that = (AbstractShip) object;
    return Objects.equals(size, that.size)
        && Objects.equals(numHitCells, that.numHitCells);
  }

  /**
   * .
   * calculate hash code
   *
   * @return hash code value of specific instance of this class
   */

  @Override
  public int hashCode() {

    return Objects.hash(size, numHitCells);
  }
}
