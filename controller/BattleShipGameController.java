package edu.neu.ccs.cs5004.assignment5.battleship.controller;

import edu.neu.ccs.cs5004.assignment5.battleship.model.Model;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.AbstractMap;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Objects;

/**
 * Representing the BattleShipGameController.
 */
public class BattleShipGameController implements Controller {
  private Model battleShipModel;

  /**
   * addModel method.
   *
   * @param battleShipModel add the battleShipModel to this controller
   */
  public void addModel(Model battleShipModel) {
    this.battleShipModel = battleShipModel;
  }

  /**
   * setupGame method.
   *
   * @throws IOException when buffer encounter exception
   */
  protected void setUpGame() throws IOException {
    InputStreamReader input = new InputStreamReader(System.in, Charset.defaultCharset());
    BufferedReader reader = new BufferedReader(input);

    System.out.println("Please choose mode: ");
    System.out.println("Enter 1 to choose Game Mode ");
    System.out.println("Enter 2 to choose Debug Mode ");

    String number = reader.readLine();

    while (!validModeInput(number)) {
      System.out.println("Choose the wrong number , please enter again ");
      number = reader.readLine();
    }

    if (number.equals("1")) {
      this.battleShipModel.setGameView();
      this.battleShipModel.setGameModeConfiguration();
    } else if (number.equals("2")) {
      this.battleShipModel.setDebugView();
      this.setConfiguration();
    }

  }

  /**
   * setConfiguration method.
   *
   * @throws IOException when buffer encounter exception
   */
  protected void setConfiguration() throws IOException {
    this.battleShipModel.setDebugModeConfiguration(
        getAmountInput("How many battleships do you want to place? (Range: 0-1)",
            Configuration.DEFAULT_NUM_BATTLE_SHIP),
        getAmountInput("How many cruisers do you want to place? (Range: 0-2)",
            Configuration.DEFAULT_NUM_CRUISER_SHIP),
        getAmountInput("How many destroyer do you want to place? (Range: 0-4)",
            Configuration.DEFAULT_NUM_DESTROYER_SHIP),
        getAmountInput("How many submarines do you want to place? (Range: 0-3)",
            Configuration.DEFAULT_NUM_SUBMARINE_SHIP));
  }

  /**
   * Get input amount.
   *
   * @param msg     msg
   * @param maximum maximum
   * @return amount
   * @throws IOException exception
   */

  protected int getAmountInput(String msg, int maximum) throws IOException {
    InputStreamReader input = new InputStreamReader(System.in, Charset.defaultCharset());
    BufferedReader reader = new BufferedReader(input);

    System.out.println(msg);


    String number = reader.readLine();

    while (!(validAmountInput(number, maximum))) {
      System.out.println("wrong number, please enter again");
      number = reader.readLine();
    }

    return Integer.parseInt(number);
  }

  /**
   * placeShip method.
   *
   * @throws IOException when buffer encounter exception
   */
  protected void placeShip() throws IOException {

    InputStreamReader input = new InputStreamReader(System.in, Charset.defaultCharset());
    BufferedReader inputLine = new BufferedReader(input);

    System.out.println("please choose how you want to place the ship");
    System.out.println("Enter 1 to place ship by user ");
    System.out.println("Enter 2 to place ship randomly ");

    String number = inputLine.readLine();

    while (!validPlaceShipInput(number)) {
      System.out.println("wrong number, please enter again");
      number = inputLine.readLine();
    }


    if (number.equals("1")) {
      for (int i = 0; i < 10; i++) {
        this.placeByUser();
      }
    } else if (number.equals("2")) {
      this.placeInRandom();
    }
  }

  /**
   * placeByUser method.
   */

  private void placeByUser() {
    InputStreamReader input = new InputStreamReader(System.in, Charset.defaultCharset());
    BufferedReader reader = new BufferedReader(input);

    try {
      System.out.println("Please choose the type of ship you want to place:");
      System.out.println("Enter 1 battleship ");
      System.out.println("Enter 2 cruiser");
      System.out.println("Enter 3 submarine");
      System.out.println("Enter 4 destroyer");


      String shipType = reader.readLine();

      while (!validShipTypeInput(shipType)) {
        System.out.println("wrong type, please enter again");
        shipType = reader.readLine();
      }

      System.out.println("Please choose a row from 1 to 10");


      String rowInput = reader.readLine();

      while (!validRowInput(rowInput)) {
        System.out.println("wrong row, please enter again");
        rowInput = reader.readLine();
      }

      System.out.println("Please choose a column from A to J");

      String columnInput = reader.readLine();

      while (!validColumnInput(columnInput)) {
        System.out.println("wrong column please enter again");
        columnInput = reader.readLine();
      }

      System.out.println("Please decide the direction(horizontal/vertical) you wanna place:");
      System.out.println("Enter 0 to place ship horizontally ");
      System.out.println("Enter 1 to place ship vertically");

      String directionType = reader.readLine();

      while (!validDirectionType(directionType)) {
        System.out.println("wrong direction type, please enter again");

        directionType = reader.readLine();
      }

      this.battleShipModel.placeByUser(rowInput, columnInput, directionType, shipType);
    } catch (IllegalArgumentException o) {
      System.out.println("you can not place this type of battleship anymore, please choose again");
      this.placeByUser();
    } catch (IOException o) {
      System.out.println("you can not place ship here , please choose again");
      this.placeByUser();
    }

  }

  /**
   * placeInRandom method.
   */
  private void placeInRandom() {
    this.battleShipModel.placeInRandom();
  }

  /**
   * set up enemy.
   */

  private void setUpEnemy() {
    this.battleShipModel.enemyPlaceInRandom();
  }

  /**
   * playGame method.
   *
   * @throws IOException when buffer encounter exception
   */
  protected void playGame() throws IOException {

    System.out.println("Let's play!\n");

    try {

      InputStreamReader input = new InputStreamReader(System.in, Charset.defaultCharset());
      BufferedReader reader = new BufferedReader(input);

      System.out.println("Please choose the strategy you want to attack");
      System.out.println("Enter 1 to choose user strategy");
      System.out.println("Enter 2 to choose random strategy");
      System.out.println("Enter 3 to choose smart strategy");

      String strategy = reader.readLine();

      while (!validStrategyInput(strategy)) {
        System.out.println("wrong number, please choose again");
        strategy = reader.readLine();
      }

      if (strategy.equals("1")) {
        this.userAttack();
      } else if (strategy.equals("2")) {
        this.userRandomAttack();
      } else {
        this.smartAttack();
      }

      reader.close();
      input.close();
    } catch (IOException o) {
      System.out.println("wrong");

    }
  }

  /**
   * start the user attack.
   *
   * @throws IOException exception
   */

  private void userAttack() throws IOException {

    while (!this.battleShipModel.gameOver()) {
      try {
        InputStreamReader input = new InputStreamReader(System.in, Charset.defaultCharset());
        BufferedReader reader = new BufferedReader(input);

        System.out.println("Please choose the row you want to attack (1-10)");
        String rowInput = reader.readLine();

        while (!validRowInput(rowInput)) {
          System.out.println("wrong number, please enter again");
          rowInput = reader.readLine();
        }

        System.out.println("Please choose the column you want to attack (A to J)");
        String columnInput = reader.readLine();

        while (!validColumnInput(columnInput)) {
          System.out.println("wrong letter, please enter again");
          columnInput = reader.readLine();
        }

        this.battleShipModel.userAttack(rowInput, columnInput);
        this.battleShipModel.enemyRandomAttack();
      } catch (IllegalArgumentException t) {
        this.battleShipModel.enemyRandomAttack();
      } catch (IOException o) {
        System.out.println("you can not attack here");
        this.userAttack();
      }
    }

    System.out.println(this.battleShipModel.gameResult());

  }

  /**
   * start the random attack.
   */

  private void userRandomAttack() {

    while (!this.battleShipModel.gameOver()) {
      this.battleShipModel.userRandomAttack();
      this.battleShipModel.enemyRandomAttack();
    }

    System.out.println(this.battleShipModel.gameResult());
  }

  /**
   * start the smart attack.
   */


  private void smartAttack() {
    while (!this.battleShipModel.gameOver()) {
      this.battleShipModel.userSmartAttack();
      this.battleShipModel.enemySmartAttack();
    }

    System.out.println(this.battleShipModel.gameResult());

  }

  /**
   * validRowInput method.
   *
   * @param str input String
   * @return true if the input String is valid otherwise return false
   */
  protected boolean validRowInput(String str) {
    if (str == null) {
      return false;
    }
    for (int i = 0; i < str.length(); i++) {
      if (!Character.isDigit(str.charAt(i))) {
        return false;
      }
    }

    return !(Integer.parseInt(str) > AbstractMap.MAPSIZE || Integer.parseInt(str) < 1);
  }

  /**
   * validColumnInput method.
   *
   * @param str input String
   * @return true if the input String is valid otherwise return false
   */
  protected boolean validColumnInput(String str) {
    if (str == null) {
      return false;
    }
    return str.length() == 1 && str.charAt(0) >= 'A' && str.charAt(0) <= 'J';
  }

  /**
   * Check valid direction type.
   */

  protected boolean validDirectionType(String str) {
    if (str == null) {
      return false;
    }

    return str.equals("1") || str.equals("0");
  }

  /**
   * check ship type input.
   */

  protected boolean validShipTypeInput(String str) {
    if (str == null) {
      return false;
    }

    return str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4");
  }


  /**
   * validAmountInput method.
   *
   * @param str input String
   * @return true if the input String is valid otherwise return false
   */
  protected boolean validAmountInput(String str, int maximum) {
    if (str == null) {
      return false;
    }
    str = str.trim();

    if (str.length() > 1 || !Character.isDigit(str.charAt(0))) {
      return false;
    }

    return Integer.parseInt(str) <= maximum;
  }

  /**
   * check strategy input.
   */

  protected boolean validStrategyInput(String str) {
    if (str == null) {
      return false;
    }

    return str.equals("1") || str.equals("2") || str.equals("3");
  }

  /**
   * check valid mode input.
   */

  protected boolean validModeInput(String str) {
    if (str == null) {
      return false;
    }

    return str.equals("1") || str.equals("2");
  }

  /**
   * check place ship input.
   */

  protected boolean validPlaceShipInput(String str) {
    if (str == null) {
      return false;
    }

    return str.equals("1") || str.equals("2");
  }

  /**
   * startGame method.
   *
   * @throws IOException when the buffer inside the game encounter exception
   */
  public void startGame() throws IOException {
    setUpGame();
    setUpEnemy();
    placeShip();
    playGame();
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
    BattleShipGameController that = (BattleShipGameController) obj;
    return Objects.equals(battleShipModel, that.battleShipModel);
  }

  /**
   * override the hashcode method.
   *
   * @return the hashcode of the object
   */
  @Override
  public int hashCode() {

    return Objects.hash(battleShipModel);
  }

  /**
   * override the toString method.
   *
   * @return the string of the object
   */
  @Override
  public String toString() {
    return "BattleShipGameController{" + "battleShipModel="
        + battleShipModel + '}';
  }
}
