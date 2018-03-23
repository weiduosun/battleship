package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

import java.util.Objects;

/**
 * .
 * Represents concrete specific ship cell
 */

public class SpecificShipCell extends ShipCell {

  private Ship ship;

  /**
   * .
   * constructor of SpecificShipCell
   *
   * @param ship the ship that placed on this cell
   */

  public SpecificShipCell(Ship ship) {
    super();
    this.ship = ship;
  }

  /**
   * .
   * get the result when this cell is attacked
   *
   * @return new attackresult object when this cell is attacked
   */

  @Override
  public AttackResult attack() {
    if (!this.isCellHit()) {
      this.setHit(true);

      this.ship.updateHitCell();

      if (this.ship.isShipSunk()) {
        this.setCellSunkStatus(true);
        return new Sunk();
      }
    }
    return new Hit();
  }

  @Override
  public Ship getShipType() {
    return this.ship;
  }

  /**
   * Get the type of the cell.
   *
   * @return the type of the cell
   */

  @Override
  public String getCellType() {
    return "specificshipcell";
  }


  /**
   * .
   * compare object with instance of specific ship cell class
   *
   * @param object the object to be compared with specific instance of this class
   * @return true if the two object are the same, false otherwise
   */

  @Override
  public boolean equals(Object object) {

    if (!super.equals(object)) {
      return false;
    }

    SpecificShipCell that = (SpecificShipCell) object;
    return Objects.equals(ship, that.ship);
  }


  /**
   * .
   * calculate hash code
   *
   * @return hash code value of specific instance of this class
   */

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), ship);
  }

  /**
   * .
   * represent information in specific ship cell object as a string
   *
   * @return string to represent the information in general specific ship cell object
   */

  @Override
  public String toString() {
    return "SpecificShipCell{"
        + "ship=" + ship
        + ", isCellSunk=" + this.getCellSunkStatus()
        + ", hit=" + this.isCellHit()
        + '}';
  }
}
