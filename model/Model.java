package edu.neu.ccs.cs5004.assignment5.battleship.model;

import edu.neu.ccs.cs5004.assignment5.battleship.model.map.FleetMap;

import java.io.IOException;


/**
 * represent the model interface.
 */

public interface Model {

  /**
   * create a new battleshipmodel object.
   *
   * @return a new battleshipmodel object
   */

  static Model createModel() {
    return new BattleShipModel();
  }

  /**
   * set view for game mode.
   */

  void setGameView();

  /**
   * set view for debug mode.
   */

  void setDebugView();

  /**
   * set configuration for game mode.
   */

  void setGameModeConfiguration();

  /**
   * set configuration for debug mode.
   *
   * @param numOfBattleShip number of battleship in configuration
   * @param numOfCruiser    number of cruiser in configuration
   * @param numOfDestroyer  number of destroyer in configuration
   * @param numOfSubmarine  number of submarine in configuration
   */

  void setDebugModeConfiguration(int numOfBattleShip, int numOfCruiser,
                                 int numOfDestroyer, int numOfSubmarine);

  /**
   * .
   * user attack mode
   *
   * @param rowInput    the row you want to attack
   * @param columnInput the colum you want to attack
   * @throws IOException exception
   */


  void userAttack(String rowInput, String columnInput) throws IOException;

  /**
   * .
   * usere smart attack
   */

  void userSmartAttack();

  /**
   * .
   * enemy smart attack
   *
   * @throws IllegalArgumentException exception
   */

  void enemySmartAttack();

  /**
   * .
   * usere random attack
   */

  void userRandomAttack();

  /**
   * .
   * enemy random attack
   *
   * @throws IllegalArgumentException exception
   */

  void enemyRandomAttack();


  /**
   * place ship as user wanted.
   *
   * @param row       the row where shipcell will be put
   * @param col       the column where shipcell will be put
   * @param direction the direction of the ship
   * @param shipType  the type of the ship
   * @throws IOException exception
   */

  void placeByUser(String row, String col, String direction, String shipType) throws IOException;

  /**
   * .
   * place ship by user randomly
   */

  void placeInRandom();

  /**
   * .
   * place ship by computer randomly
   */

  void enemyPlaceInRandom();

  /**
   * .
   * check if the game is over
   *
   * @return true if it is, false otherwise
   */

  Boolean gameOver();

  /**
   * .
   * get the winner of the game
   *
   * @return the winner of the game
   */

  String gameResult();

  /**
   * .
   * get the user's game map
   *
   * @return the user's game map
   */

  FleetMap getMyMap();

  /**
   * get the enemy's map.
   *
   * @return the enemy's map
   */

  FleetMap getEnemyMap();
}
