package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

/**
 * .
 * Represents cell interface with two methods
 */

public interface Cell {

  /**
   * .
   * check if the ship can be placed in this cell
   *
   * @return true if ship can place the cell , false otherwise
   */

  Boolean canPlace();

  /**
   * .
   * get the result
   *
   * @return true if ship can place the cell , false otherwise
   */

  AttackResult attack();

  /**
   * .
   * true if the cell is hit
   *
   * @return true if the cell is hit, false otherwise
   */

  Boolean isCellHit();

  /**
   * .
   * true if the cell is hit
   *
   * @return true if the cell is hit, false otherwise
   */

  Boolean getCellSunkStatus();

  /**
   * .
   * set the sunk status of cell
   */

  void setCellSunkStatus(Boolean status);

  /**
   * .
   * get the type of ship this cell contains;
   */

  Ship getShipType();

  /**
   * Get the type of cell.
   *
   * @return the type of cell in string
   */

  String getCellType();
}
