package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

/**
 * .
 * Represents cell with adjacent ship cell
 */

public class GapCell extends WaterCell {

  /**
   * .
   * check if the ship can be placed in this cell
   *
   * @return true ,cause it is open sea cell
   */

  @Override
  public Boolean canPlace() {
    return false;
  }

  /**
   * the type of the cell.
   *
   * @return the type of the cell
   */

  @Override
  public String getCellType() {
    return "gapcell";
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
    int result = super.hashCode();
    result = result * 31 + 37;
    return result;
  }

  /**
   * .
   * represent information in specific ship cell object as a string
   *
   * @return string to represent the information in general specific ship cell object
   */

  @Override
  public String toString() {
    return "GapCell{"
        + "hit=" + this.isCellHit()
        + '}';
  }
}
