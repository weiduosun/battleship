package edu.neu.ccs.cs5004.assignment5.battleship.model;

import edu.neu.ccs.cs5004.assignment5.battleship.model.map.AbstractMap;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Configuration;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.FleetMap;
import edu.neu.ccs.cs5004.assignment5.battleship.model.placement.Placement;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.SpecificShipCell;
import edu.neu.ccs.cs5004.assignment5.battleship.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;


/**
 * represent the battleship model.
 */

public class BattleShipModel extends Observable implements Model {
  private FleetMap myMap;
  private FleetMap enemyMap;
  private ArrayList<View> listOfObserver;
  private Configuration userConfiguration;
  private Configuration enemyConfiguration;
  private String typeOfView;
  private Placement userPlacement;
  private Placement enemyPlacement;
  private String finalGameResult;
  private static final int ASCII_OF_A = 65;

  /**
   * constructor of battleship model.
   */

  public BattleShipModel() {
    this.myMap = new FleetMap();
    this.enemyMap = new FleetMap();
    this.listOfObserver = new ArrayList<View>();
  }

  /**
   * Get user's game map.
   *
   * @return user's game map
   */

  @Override
  public FleetMap getMyMap() {
    return this.myMap;
  }

  /**
   * Get enemy's map.
   *
   * @return enemy's map
   */

  @Override
  public FleetMap getEnemyMap() {
    return this.enemyMap;
  }

  /**
   * Get a list of observer.
   *
   * @return list of observer.
   */

  public ArrayList<View> getListOfObserver() {
    return listOfObserver;
  }

  /**
   * Place ship as user wanted.
   *
   * @param row       the row where shipcell will be put
   * @param col       the column where shipcell will be put
   * @param direction the direction of the ship
   * @param shipType  the type of the ship
   * @throws IOException exception
   */

  @Override
  public void placeByUser(String row, String col,
                          String direction, String shipType) throws IOException {
    this.userPlacement.userPlacement(row, col, direction, shipType, this.myMap);
    this.notifyObservers();
  }

  /**
   * .
   * place ship by user randomly
   */


  @Override
  public void placeInRandom() {
    this.userPlacement.randomPlacement(this.myMap);
    this.notifyObservers();
  }

  /**
   * .
   * place ship by computer randomly
   */

  @Override
  public void enemyPlaceInRandom() throws IllegalArgumentException {
    this.enemyPlacement.randomPlacement(this.enemyMap);
  }

  /**
   * .
   * check if the game is over
   *
   * @return true if it is, false otherwise
   */

  @Override
  public Boolean gameOver() {
    Boolean myResult = checkGameMap(this.myMap);
    Boolean enemyResult = checkGameMap(this.enemyMap);

    if (myResult) {
      this.finalGameResult = "Enemy Wins !";
    }

    if (enemyResult) {
      this.finalGameResult = "You Wins !";
    }

    return myResult || enemyResult;
  }

  /**
   * .
   * check if the ship cells in the map are all hit
   *
   * @param map the map need to be checked
   * @return true if all ship cells are hit, false otherwise
   */

  private Boolean checkGameMap(FleetMap map) {
    Cell[][] gameMap = map.getMap();

    for (int i = 0; i < gameMap.length; i++) {
      for (int j = 0; j < gameMap[0].length; j++) {
        if (gameMap[i][j].getClass().equals(SpecificShipCell.class) && !gameMap[i][j].isCellHit()) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * .
   * get the winner of the game
   *
   * @return the winner of the game
   */

  @Override
  public String gameResult() {
    return this.finalGameResult;
  }

  /**
   * getter for type of view.
   *
   * @return type of view
   */

  public String getTypeOfView() {
    return typeOfView;
  }

  /**
   * set view for game mode.
   */

  @Override
  public void setGameView() {
    this.typeOfView = "gameview";

    this.registerObserver(View.createView());
  }

  /**
   * set view for debug mode.
   */

  @Override
  public void setDebugView() {
    this.typeOfView = "debugview";
    this.registerObserver(View.createView());
  }

  /**
   * set configuration for game mode.
   */

  @Override
  public void setGameModeConfiguration() {
    this.userConfiguration = new Configuration();
    this.enemyConfiguration = new Configuration();
    this.userPlacement = new Placement(new Configuration());
    this.enemyPlacement = new Placement(new Configuration());
  }

  /**
   * set configuration for debug mode.
   *
   * @param numOfBattleShip number of battleship in configuration
   * @param numOfCruiser    number of cruiser in configuration
   * @param numOfDestroyer  number of destroyer in configuration
   * @param numOfSubmarine  number of submarine in configuration
   */

  @Override
  public void setDebugModeConfiguration(int numOfBattleShip, int numOfCruiser,
                                        int numOfDestroyer, int numOfSubmarine) {
    this.userConfiguration = new Configuration(numOfBattleShip, numOfCruiser,
        numOfDestroyer, numOfSubmarine);
    this.enemyConfiguration = new Configuration(numOfBattleShip, numOfCruiser,
        numOfDestroyer, numOfSubmarine);
    this.userPlacement = new Placement(this.userConfiguration);
    this.enemyPlacement = new Placement(this.enemyConfiguration);
  }

  /**
   * .
   * user attack mode
   *
   * @param rowInput    the row you want to attack
   * @param columnInput the colum you want to attack
   * @throws IOException exception
   */

  @Override
  public void userAttack(String rowInput, String columnInput) throws IOException {
    int row = Integer.parseInt(rowInput) - 1;
    int col = columnInput.charAt(0) - ASCII_OF_A;

    if (this.enemyMap.getCell(row, col).isCellHit()) {
      throw new IOException();
    }

    this.enemyMap.getCell(row, col).attack();
    this.enemyMap.scan();
    this.notifyObservers();
  }

  /**
   * User smart attack.
   */
  @Override
  public void userSmartAttack() {
    int row = randomWithRange(0, AbstractMap.MAPSIZE - 1);
    int col = randomWithRange(0, AbstractMap.MAPSIZE - 1);

    while (this.enemyMap.getCell(row, col).isCellHit()) {
      if (row < AbstractMap.MAPSIZE - 1 && row > 0 && col > 0 && col < AbstractMap.MAPSIZE - 1) {
        if (!this.enemyMap.getCell(row - 1, col).isCellHit()) {
          row = row - 1;
        } else if (!this.enemyMap.getCell(row + 1, col).isCellHit()) {
          row = row + 1;
        } else if (!this.enemyMap.getCell(row, col + 1).isCellHit()) {
          col = col + 1;
        } else if (!this.enemyMap.getCell(row, col - 1).isCellHit()) {
          col = col - 1;
        } else {
          row = randomWithRange(0, AbstractMap.MAPSIZE - 1);
          col = randomWithRange(0, AbstractMap.MAPSIZE - 1);
        }
      } else {
        row = randomWithRange(0, AbstractMap.MAPSIZE - 1);
        col = randomWithRange(0, AbstractMap.MAPSIZE - 1);
      }
    }

    this.enemyMap.getCell(row, col).attack();
    this.enemyMap.scan();
    this.notifyObservers();
  }

  /**
   * Enemy smart attack.
   */
  @Override
  public void enemySmartAttack() {
    int row = randomWithRange(0, AbstractMap.MAPSIZE - 1);
    int col = randomWithRange(0, AbstractMap.MAPSIZE - 1);

    while (this.myMap.getCell(row, col).isCellHit()) {
      if (row < AbstractMap.MAPSIZE - 1 && row > 0 && col > 0 && col < AbstractMap.MAPSIZE - 1) {
        if (!this.myMap.getCell(row - 1, col).isCellHit()) {
          row = row - 1;
        } else if (!this.myMap.getCell(row + 1, col).isCellHit()) {
          row = row + 1;
        } else if (!this.myMap.getCell(row, col + 1).isCellHit()) {
          col = col + 1;
        } else if (!this.myMap.getCell(row, col - 1).isCellHit()) {
          col = col - 1;
        } else {
          row = randomWithRange(0, AbstractMap.MAPSIZE - 1);
          col = randomWithRange(0, AbstractMap.MAPSIZE - 1);
        }
      } else {
        row = randomWithRange(0, AbstractMap.MAPSIZE - 1);
        col = randomWithRange(0, AbstractMap.MAPSIZE - 1);
      }
    }

    this.myMap.getCell(row, col).attack();

    if (this.typeOfView.equals("debugview")) {
      this.myMap.scan();
      this.notifyObservers();
    }
  }

  /**
   * user random attack.
   */

  @Override
  public void userRandomAttack() {
    int row = randomWithRange(0, AbstractMap.MAPSIZE - 1);
    int col = randomWithRange(0, AbstractMap.MAPSIZE - 1);

    while (this.enemyMap.getCell(row, col).isCellHit()) {
      row = randomWithRange(0, AbstractMap.MAPSIZE - 1);
      col = randomWithRange(0, AbstractMap.MAPSIZE - 1);
    }

    this.enemyMap.getCell(row, col).attack();
    this.enemyMap.scan();
    this.notifyObservers();
  }

  /**
   * .
   * enemy random attack
   */

  @Override
  public void enemyRandomAttack() {
    int row = randomWithRange(0, AbstractMap.MAPSIZE - 1);
    int col = randomWithRange(0, AbstractMap.MAPSIZE - 1);

    while (this.myMap.getCell(row, col).isCellHit()) {
      row = randomWithRange(0, AbstractMap.MAPSIZE - 1);
      col = randomWithRange(0, AbstractMap.MAPSIZE - 1);
    }

    this.myMap.getCell(row, col).attack();

    if (this.typeOfView.equals("debugview")) {
      this.myMap.scan();
      this.notifyObservers();
    }

  }

  /**
   * Returns the random range.
   *
   * @param min lower bound
   * @param max upper bound
   * @return the random range
   */
  private int randomWithRange(int min, int max) {
    Random ran = new Random();
    int range = (max - min) + 1;
    return ran.nextInt(range) + min;
  }

  /**
   * add observer to the list.
   *
   * @param observer the observer you want to add
   */

  @Override
  public void registerObserver(View observer) {
    this.listOfObserver.add(observer);
  }

  /**
   * remove observer from the list.
   *
   * @param observer the observer you want to remove
   */

  @Override
  public void removeObserver(View observer) {
    this.listOfObserver.remove(observer);
  }

  /**
   * notify the observer whenever observable changes.
   */

  @Override
  public void notifyObservers() {
    for (View modelObserver : listOfObserver) {
      if (this.typeOfView.equals("gameview")) {
        modelObserver.updateGameView(this);
      } else {
        modelObserver.updateDebugView(this);
      }
    }
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    BattleShipModel that = (BattleShipModel) object;
    return Objects.equals(myMap, that.myMap)
        && Objects.equals(enemyMap, that.enemyMap)
        && Objects.equals(listOfObserver, that.listOfObserver)
        && Objects.equals(userConfiguration, that.userConfiguration)
        && Objects.equals(enemyConfiguration, that.enemyConfiguration)
        && Objects.equals(typeOfView, that.typeOfView)
        && Objects.equals(userPlacement, that.userPlacement)
        && Objects.equals(enemyPlacement, that.enemyPlacement)
        && Objects.equals(finalGameResult, that.finalGameResult);
  }

  @Override
  public int hashCode() {
    return Objects.hash(myMap, enemyMap, listOfObserver, userConfiguration, enemyConfiguration,
        typeOfView, userPlacement, enemyPlacement, finalGameResult);
  }

  @Override
  public String toString() {
    return "BattleShipModel{"
        + "myMap=" + myMap
        + ", enemyMap=" + enemyMap
        + ", listOfObserver=" + listOfObserver
        + ", userConfiguration=" + userConfiguration
        + ", enemyConfiguration=" + enemyConfiguration
        + ", typeOfView='" + typeOfView + '\''
        + ", userPlacement=" + userPlacement
        + ", enemyPlacement=" + enemyPlacement
        + ", finalGameResult='" + finalGameResult + '\''
        + "} " + super.toString();
  }
}
