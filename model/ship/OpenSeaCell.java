package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

/**
 * .
 * Represents cell with no adjacent ship cell
 */

public class OpenSeaCell extends WaterCell {

  /**
   * .
   * check if the ship can be placed in this cell
   *
   * @return true ,cause it is open sea cell
   */

  @Override
  public Boolean canPlace() {
    return true;
  }

  /**
   * the type of the cell.
   *
   * @return the type of the cell
   */

  @Override
  public String getCellType() {
    return "openseacell";
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
    int result = super.hashCode();
    result = result * 31 + 97;
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
    return "OpenSeaCell{"
        + "hit=" + this.isCellHit()
        + '}';
  }
}
