package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

import java.util.Objects;

/**
 * .
 * Represents ship cell abstract class
 */

public abstract class ShipCell extends AbstractCell {

  /**
   * .
   * constructor of ship cell
   */

  private Boolean isCellSunk;

  ShipCell() {
    super();
    this.isCellSunk = false;
  }

  /**
   * .
   * get the value of isCellSunk
   *
   * @return the boolean value of isCellSunk
   */

  public Boolean getCellSunkStatus() {
    return this.isCellSunk;
  }

  /**
   * .
   * setter
   */

  public void setCellSunkStatus(Boolean status) {
    this.isCellSunk = status;
  }


  /**
   * .
   * check if the ship can be placed in this cell
   *
   * @return false , cause it is a ship cell
   */

  @Override
  public Boolean canPlace() {
    return false;
  }

  /**
   * .
   * compare object with instance of shipcell class
   *
   * @param object the object to be compared with specific instance of this class
   * @return true if the two object are the same, false otherwise
   */

  @Override
  public boolean equals(Object object) {

    if (!super.equals(object)) {
      return false;
    }
    ShipCell shipCell = (ShipCell) object;
    return Objects.equals(isCellSunk, shipCell.isCellSunk);
  }

  /**
   * .
   * calculate hash code
   *
   * @return hash code value of specific instance of this class
   */

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), isCellSunk);
  }
}
