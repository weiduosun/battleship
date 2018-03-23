package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

/**
 * .
 * Represents abstract class water cell
 */

public abstract class WaterCell extends AbstractCell {

  /**
   * .
   * constructor of SpecificShipCell
   */

  WaterCell() {
    super();
  }

  /**
   * .
   * get the result when this cell is attacked
   *
   * @return new attackresult object when this cell is attacked
   */

  public Boolean getCellSunkStatus() {
    return false;
  }

  public Ship getShipType() {
    return null;
  }

  @Override
  public AttackResult attack() {
    this.setHit(true);
    return new Miss();
  }
}
