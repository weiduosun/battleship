package edu.neu.ccs.cs5004.assignment5.battleship.model.map;

/**
 * representing the abstract class abstractMap.
 */

public abstract class AbstractMap implements Map {
  public static final int MAPSIZE = 10;

  /**
   * Get the size of the map.
   *
   * @return the size of the map
   */

  public Integer getSize() {
    return MAPSIZE;
  }
}
