package edu.neu.ccs.cs5004.assignment5.battleship.model.map;

import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Posn;

/**
 * Represents a map.
 */
public interface Map {

  /**
   * Returns a cell on the position.
   *
   * @param posn a position
   * @return a cell on this position
   */
  Cell getCell(Posn posn);

  /**
   * Returns a cell on the position.
   *
   * @param row row index
   * @param col column index
   * @return a cell on this position
   */

  Cell getCell(Integer row, Integer col);

  /**
   * getMap method.
   *
   * @return the map
   */
  Cell[][] getMap();


  /**
   * canPlaceCell method.
   *
   * @param row    input row
   * @param column input column
   * @return true if the input cell can place cell otherwise return false
   */
  boolean canPlaceCell(int row, int column);

  /**
   * Set a cell on a position.
   *
   * @param posn a position
   * @param cell a cell
   */
  void setCell(Posn posn, Cell cell);

  /**
   * Set a cell in a position.
   *
   * @param row    an index of row
   * @param column an index of column
   * @param cell   a cell to be set
   */
  void setCell(int row, int column, Cell cell);

  /**
   * Get the size of the map.
   *
   * @return the size of map
   */

  Integer getSize();
}
