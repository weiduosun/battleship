package edu.neu.ccs.cs5004.assignment5.battleship.model.placement;

import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Configuration;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.FleetMap;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.AbstractShip;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Battleship;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Cruiser;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Destroyer;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.GapCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.SpecificShipCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Submarine;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;


/**
 * Represents a placement of ship.
 */
public class Placement {
  /*
  private field of placement
   */
  private Configuration configuration;

  private static final int MAX_NUM_SHIP_TYPE = 4;
  private static final int MAX_NUM_DIRECTION = 2;
  private static final int ASCII_OF_A = 65;

  /**
   * constructor of placement.
   *
   * @param configuration input configuration
   */
  public Placement(Configuration configuration) {
    this.configuration = configuration;
  }

  /**
   * randomoPlacement method.
   * randomly place ships on the map
   *
   * @param fleetMap input fleeMap
   */
  public void randomPlacement(FleetMap fleetMap) {
    int row;
    int col;
    int direction;
    int numShipType;
    AbstractShip ship;

    boolean inputMessage = true;

    while (inputMessage) {

      row = new Random().nextInt(FleetMap.MAPSIZE - 1) + 1;
      col = new Random().nextInt(FleetMap.MAPSIZE - 1) + 1;
      direction = new Random().nextInt(MAX_NUM_DIRECTION);
      numShipType = new Random().nextInt(MAX_NUM_SHIP_TYPE);

      if (numShipType == 1 && randomShipCount(numShipType)) {
        ship = new Battleship();
      } else if (numShipType == 2 && randomShipCount(numShipType)) {
        ship = new Cruiser();
      } else if (numShipType == 3 && randomShipCount(numShipType)) {
        ship = new Submarine();
      } else if (numShipType == 0 && randomShipCount(numShipType)) {
        ship = new Destroyer();
      } else {
        continue;
      }

      if (canPlaceShip(new Posn(row, col), direction, ship, fleetMap)) {
        placeShip(new Posn(row, col), direction, ship, fleetMap);
        addShipCount(ship);
        if (stopPlaceShip()) {
          inputMessage = false;
        }
      }
    }
  }

  /**
   * userPlacement method.
   *
   * @param rowInput      input row
   * @param colInput      input col
   * @param directionType input direction
   * @param type          input type
   * @param fleetMap      input Fleetmap
   * @throws IOException when the buffer encounter exception
   */
  public void userPlacement(String rowInput, String colInput, String directionType,
                            String type, FleetMap fleetMap) throws IOException {

    String shipType = shipTypeConvert(type);

    if (!userShipCount(shipType)) {
      throw new IllegalArgumentException();
    }


    AbstractShip ship;
    int row = Integer.parseInt(rowInput) - 1;
    int col = colInput.charAt(0) - ASCII_OF_A;

    int direction;
    direction = Integer.parseInt(directionType);

    if (shipType.equals("battleship")) {
      ship = new Battleship();
    } else if (shipType.equals("cruiser")) {
      ship = new Cruiser();
    } else if (shipType.equals("submarine")) {
      ship = new Submarine();
    } else {
      ship = new Destroyer();
    }

    if (canPlaceShip(new Posn(row, col), direction, ship, fleetMap)) {
      placeShip(new Posn(row, col), direction, ship, fleetMap);
      addShipCount(ship);
    } else {
      throw new IOException();
    }
  }

  /**
   * canPlaceShip method.
   *
   * @param posn                 input posn
   * @param directionOfPlacement input direction of placement
   * @param ship                 input ship
   * @param fleetMap             input fleetmap
   * @return true if it can place ship, otherwise return false
   */
  private boolean canPlaceShip(Posn posn, int directionOfPlacement,
                               AbstractShip ship, FleetMap fleetMap) {
    int shipSize = ship.getShipSize();
    int indexOfRow = posn.getRow();
    int indexOfColumn = posn.getCol();
    if (directionOfPlacement == 1) {
      for (int i = indexOfRow; i < indexOfRow + shipSize; i++) {
        if (i >= FleetMap.MAPSIZE || !fleetMap.canPlaceCell(i, indexOfColumn)) {
          return false;
        }
      }
    } else if (directionOfPlacement == 0) {
      for (int j = indexOfColumn; j < indexOfColumn + shipSize; j++) {
        if (j >= FleetMap.MAPSIZE || !fleetMap.canPlaceCell(indexOfRow, j)) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * place ship method.
   * place the ship on the map base on the input
   *
   * @param posn                 input posn
   * @param directionOfPlacement input directionPlacement
   * @param ship                 inpiut ship
   * @param fleetMap             input fleetMap
   */
  private void placeShip(Posn posn, int directionOfPlacement, AbstractShip ship,
                         FleetMap fleetMap) {
    int shipSize = ship.getShipSize();
    int indexOfRow = posn.getRow();
    int indexOfColumn = posn.getCol();

    if (directionOfPlacement == 1) {
      for (int i = indexOfRow; i < indexOfRow + shipSize; i++) {
        fleetMap.setCell(i, indexOfColumn, new SpecificShipCell(ship));
        if (indexOfColumn > 0) {
          fleetMap.setCell(i, indexOfColumn - 1, new GapCell());
        }
        if (indexOfColumn < FleetMap.MAPSIZE - 1) {
          fleetMap.setCell(i, indexOfColumn + 1, new GapCell());
        }
        if (i == indexOfRow && i > 0) {
          fleetMap.setCell(i - 1, indexOfColumn, new GapCell());
        }
        if (i == indexOfRow + shipSize - 1 && i < FleetMap.MAPSIZE - 1) {
          fleetMap.setCell(i + 1, indexOfColumn, new GapCell());
        }
      }
    } else if (directionOfPlacement == 0) {
      for (int j = indexOfColumn; j < indexOfColumn + shipSize; j++) {
        fleetMap.setCell(indexOfRow, j, new SpecificShipCell(ship));
        if (indexOfRow > 0) {
          fleetMap.setCell(indexOfRow - 1, j, new GapCell());
        }
        if (indexOfRow < FleetMap.MAPSIZE - 1) {
          fleetMap.setCell(indexOfRow + 1, j, new GapCell());
        }
        if (j == indexOfColumn && j > 0) {
          fleetMap.setCell(indexOfRow, j - 1, new GapCell());
        }
        if (j == indexOfColumn + shipSize - 1 && j < FleetMap.MAPSIZE - 1) {
          fleetMap.setCell(indexOfRow, j + 1, new GapCell());
        }
      }
    }
  }

  /**
   * randomshipcount method.
   *
   * @param numShipType input numshipType
   * @return true if the the input shiptype is valid otherwise return false
   */
  private boolean randomShipCount(int numShipType) {
    if (numShipType == 2) {
      if (configuration.getNumOfCruiser() <= 0) {
        return false;
      }
    } else if (numShipType == 0) {
      if (configuration.getNumOfDestroyer() <= 0) {
        return false;
      }
    } else if (numShipType == 3) {
      if (configuration.getNumOfSubmarine() <= 0) {
        return false;
      }
    } else {
      if (configuration.getNumOfBattleShip() <= 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * stopPlaceShip method.
   * determine if it possible to place ship
   *
   * @return true if the placeShip can still place ship otherwise return false
   */
  private boolean stopPlaceShip() {
    return 0 == configuration.getNumOfBattleShip() && 0 == configuration.getNumOfSubmarine()
        && 0 == configuration.getNumOfCruiser() && 0 == configuration.getNumOfDestroyer();
  }

  /**
   * addShipCount method.
   * add ship count base on the input ship type
   *
   * @param ship input ship
   */
  private void addShipCount(AbstractShip ship) {
    if (ship.getClass() == Battleship.class) {
      configuration.updateBattle();
    } else if (ship.getClass() == Cruiser.class) {
      configuration.updateCruiser();
    } else if (ship.getClass() == Submarine.class) {
      configuration.updateSubmarine();
    } else {
      configuration.updateDestroyer();
    }
  }

  /**
   * userShipCount method.
   *
   * @param shipType input ship type
   * @return true if the input ship type is valid otherwise return false
   */
  private boolean userShipCount(String shipType) {
    if (shipType.equals("cruiser")) {
      if (configuration.getNumOfCruiser() <= 0) {
        return false;
      }
    } else if (shipType.equals("destroyer")) {
      if (configuration.getNumOfDestroyer() <= 0) {
        return false;
      }
    } else if (shipType.equals("submarine")) {
      if (configuration.getNumOfSubmarine() <= 0) {
        return false;
      }
    } else {
      if (configuration.getNumOfBattleShip() <= 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * shipTypeConvert method.
   *
   * @param type input type
   * @return the String based on the String type
   */
  private String shipTypeConvert(String type) {
    if (type.equals("1")) {
      return "battleship";
    } else if (type.equals("2")) {
      return "cruiser";
    } else if (type.equals("3")) {
      return "submarine";
    } else {
      return "destroyer";
    }
  }

  /**
   * override the equals method.
   *
   * @param obj the input object
   * @return false if these are different objects, otherwise return true
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Placement placement = (Placement) obj;
    return Objects.equals(configuration, placement.configuration);
  }

  /**
   * override the hashcode method.
   *
   * @return the hashcode of the object
   */
  @Override
  public int hashCode() {

    return Objects.hash(configuration);
  }

  /**
   * override the toString method.
   *
   * @return the string of the object
   */
  @Override
  public String toString() {
    return "placement{" + "configuration="
        + configuration + '}';
  }
}
