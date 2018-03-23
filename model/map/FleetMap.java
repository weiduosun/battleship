package edu.neu.ccs.cs5004.assignment5.battleship.model.map;

import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.GapCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.OpenSeaCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Posn;

import java.util.Arrays;


/**
 * represent the map for the Game.
 */

public class FleetMap extends AbstractMap {

  private Cell[][] gameMap;

  private static final int MAX_LEVEL = 4;

  /**
   * the constructor of the map.
   */

  public FleetMap() {
    this.gameMap = new Cell[MAPSIZE][MAPSIZE];

    for (int i = 0; i < MAPSIZE; i++) {
      for (int j = 0; j < MAPSIZE; j++) {
        this.gameMap[i][j] = new OpenSeaCell();
      }
    }
  }

  /**
   * get the cell array.
   *
   * @return get the cell array
   */

  public Cell[][] getMap() {
    Cell[][] temp = new Cell[MAPSIZE][MAPSIZE];
    for (int i = 0; i < MAPSIZE; i++) {
      for (int j = 0; j < MAPSIZE; j++) {
        temp[i][j] = this.gameMap[i][j];
      }
    }
    return temp;
  }

  /**
   * get the cell on the map.
   *
   * @param posn the position of cell
   * @return the cell on that position
   */

  public Cell getCell(Posn posn) {
    return this.gameMap[posn.getRow()][posn.getCol()];
  }

  /**
   * get the cell on the map.
   *
   * @param row row index
   * @param col column index
   * @return the cell at that index
   */


  public Cell getCell(Integer row, Integer col) {
    return gameMap[row][col];
  }

  /**
   * change the cell on the map.
   *
   * @param posn    the position of the cell
   * @param newCell the new cell to replace old cell in that position
   */

  public void setCell(Posn posn, Cell newCell) {
    this.gameMap[posn.getRow()][posn.getCol()] = newCell;
  }

  /**
   * Set a cell in a position.
   *
   * @param row    an index of row
   * @param column an index of column
   * @param cell   a cell to be set
   */

  public void setCell(int row, int column, Cell cell) {
    gameMap[row][column] = cell;
  }


  /**
   * canPlaceCell method.
   *
   * @param row    input row
   * @param column input column
   * @return true if the position can place cell otherwise return false
   */
  public boolean canPlaceCell(int row, int column) {
    return gameMap[row][column].getClass() == OpenSeaCell.class;
  }

  /**
   * scan the map.
   */

  public void scan() {
    int length = gameMap.length;
    int width = gameMap[0].length;
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < width; j++) {
        if (gameMap[i][j].getCellSunkStatus()) {
          dfs(gameMap, i, j, 0);
        }
      }
    }
  }

  /**
   * dfs method.
   */
  private void dfs(Cell[][] map, int row, int col, int level) {
    if (row < 0 || col < 0 || row >= map.length
        || col >= map[0].length) {
      return;
    }
    if (map[row][col].getClass().equals(OpenSeaCell.class)
        || map[row][col].getClass().equals(GapCell.class)) {
      return;
    }
    if (level > MAX_LEVEL) {
      return;
    }
    level++;
    map[row][col].setCellSunkStatus(true);
    dfs(map, row + 1, col, level);
    dfs(map, row, col + 1, level);
    dfs(map, row - 1, col, level);
    dfs(map, row, col - 1, level);
  }

  /**
   * compare object with instance of this class.
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
    FleetMap fleetMap1 = (FleetMap) object;
    return Arrays.deepEquals(gameMap, fleetMap1.getMap());
  }

  /**
   * calculate hash code.
   *
   * @return hash code value of specific instance of this class
   */

  @Override
  public int hashCode() {
    return Arrays.deepHashCode(gameMap);
  }

  /**
   * represent information in this object as a string.
   *
   * @return string to represent the information in this object
   */

  @Override
  public String toString() {
    return "FleetMap{"
        + "map=" + Arrays.toString(gameMap)
        + '}';
  }
}
