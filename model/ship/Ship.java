package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

/**
 * represent the ship interface.
 */

public interface Ship {

  /**
   * check if the ship is cellSunk.
   *
   * @return true if it is, false otherwise
   */

  Boolean isShipSunk();

  /**
   * Update hit cell.
   */
  void updateHitCell();

  /**
   * Get ship size.
   *
   * @return ship size
   */
  Integer getShipSize();
}
