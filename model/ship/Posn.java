package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

import java.util.Objects;

/**
 * .
 * represent position with row and column
 */
public class Posn {
  private Integer row;
  private Integer col;

  /**
   * .
   * constructor of position
   *
   * @param row the row is a number from 1 to 10
   * @param col the column is character from A to J
   */


  public Posn(Integer row, Integer col) {
    this.row = row;
    this.col = col;
  }

  /**
   * .
   * get the row index
   *
   * @return the row index
   */

  public Integer getRow() {
    return this.row ;
  }

  /**
   * .
   * the column index
   *
   * @return the column index
   */

  public Integer getCol() {
    return this.col ;
  }

  /**.
   *
   * @param row row
   */

  public void setRow(Integer row) {
    this.row = row;
  }

  /**.
   *
   * @param col column
   */

  public void setCol(Integer col) {
    this.col = col;
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
    Posn posn = (Posn) object;
    return row.equals(posn.row)
        && Objects.equals(col, posn.col);
  }

  /**
   * .
   * calculate hash code
   *
   * @return hash code value of specific instance of this class
   */

  @Override
  public int hashCode() {

    return Objects.hash(row, col);
  }

  /**
   * .
   * represent information in this object as a string
   *
   * @return string to represent the information in this object
   */

  @Override
  public String toString() {
    return "Posn{"
        + "row=" + row
        + ", col=" + col
        + '}';
  }
}
