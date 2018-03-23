package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

import java.util.Objects;

/**
 * .
 * represent an abstract cell
 */

public abstract class AbstractCell implements Cell {
  private Boolean cellGotHit;
  private Boolean isCellSunk;

  /**
   * .
   * constructor of abstract cell
   */

  public AbstractCell() {
    this.cellGotHit = false;
    this.isCellSunk = false;
  }

  /**
   * .
   * check if the cell is cellGotHit
   *
   * @return true if the cell is cellGotHit ,false otherwise
   */

  public Boolean setHit(Boolean hitStatus) {
    return this.cellGotHit = hitStatus;
  }

  /**
   * .
   * check if the cell is cellGotHit
   *
   * @return true if the cell is cellGotHit ,false otherwise
   */

  public Boolean isCellHit() {
    return this.cellGotHit;
  }

  /**
   * Get cell sunk status.
   *
   * @return cell sunk status
   */
  public Boolean getCellSunkStatus() {
    return this.isCellSunk;
  }

  /**
   * Set cell sunk status.
   *
   * @param status sunk status
   */
  public void setCellSunkStatus(Boolean status) {
    this.isCellSunk = status;
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
    AbstractCell that = (AbstractCell) object;
    return Objects.equals(cellGotHit, that.cellGotHit);
  }

  /**
   * .
   * calculate hash code
   *
   * @return hash code value of specific instance of this class
   */

  @Override
  public int hashCode() {

    return Objects.hash(cellGotHit);
  }
}
