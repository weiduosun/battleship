package edu.neu.ccs.cs5004.assignment5.battleship.model.map;

import java.util.Objects;

/**
 * representing the class configuration.
 */
public class Configuration {
  /*
  private field
   */
  private int numOfBattleShip;
  private int numOfCruiser;
  private int numOfDestroyer;
  private int numOfSubmarine;

  /*
  public static field
   */
  public static final int DEFAULT_NUM_BATTLE_SHIP = 1;
  public static final int DEFAULT_NUM_CRUISER_SHIP = 2;
  public static final int DEFAULT_NUM_SUBMARINE_SHIP = 3;
  public static final int DEFAULT_NUM_DESTROYER_SHIP = 4;

  /**
   * constructor of Configuration.
   *
   * @param numOfBattleShip the number of battleship
   * @param numOfCruiser    the number of cruiser
   * @param numOfDestroyer  the number of destroyer
   * @param numOfSubmarine  the number of submarine
   */
  public Configuration(int numOfBattleShip, int numOfCruiser,
                       int numOfDestroyer, int numOfSubmarine) {
    this.numOfBattleShip = numOfBattleShip;
    this.numOfCruiser = numOfCruiser;
    this.numOfDestroyer = numOfDestroyer;
    this.numOfSubmarine = numOfSubmarine;

  }

  /**
   * constructor of Configuration.
   */
  public Configuration() {
    this.numOfBattleShip = DEFAULT_NUM_BATTLE_SHIP;
    this.numOfCruiser = DEFAULT_NUM_CRUISER_SHIP;
    this.numOfSubmarine = DEFAULT_NUM_SUBMARINE_SHIP;
    this.numOfDestroyer = DEFAULT_NUM_DESTROYER_SHIP;

  }

  /**
   * updateBattle method.
   * decrease the battleship number by 1
   */
  public void updateBattle() {
    --this.numOfBattleShip;
  }

  /**
   * update cruiser method.
   * decrease the cruiser number by 1
   */
  public void updateCruiser() {
    --this.numOfCruiser;
  }

  /**
   * update submarine method.
   * decrease the submarine number by 1
   */
  public void updateSubmarine() {
    --this.numOfSubmarine;
  }

  /**
   * update destroyer method.
   * decrease the destroyer number by 1
   */
  public void updateDestroyer() {
    --this.numOfDestroyer;
  }

  /**
   * getter method of battleShip.
   *
   * @return the number of battleship
   */
  public int getNumOfBattleShip() {
    return numOfBattleShip;
  }

  /**
   * getter method of cruiser.
   *
   * @return the number of cruiser
   */
  public int getNumOfCruiser() {
    return numOfCruiser;
  }

  /**
   * getter method of destroyer.
   *
   * @return the number of destroyer
   */
  public int getNumOfDestroyer() {
    return numOfDestroyer;
  }

  /**
   * getter method of submarine.
   *
   * @return the number of submarine
   */
  public int getNumOfSubmarine() {
    return numOfSubmarine;
  }

  /**
   * override the toString method.
   *
   * @return the string of the object
   */
  @Override
  public String toString() {
    return "Configuration{" + "numOfBattleShip="
        + numOfBattleShip + ", numOfCruiser="
        + numOfCruiser + ", numOfDestroyer="
        + numOfDestroyer + ", numOfSubmarine="
        + numOfSubmarine + '}';
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
    Configuration that = (Configuration) obj;
    return numOfBattleShip == that.numOfBattleShip
        && numOfCruiser == that.numOfCruiser
        && numOfDestroyer == that.numOfDestroyer
        && numOfSubmarine == that.numOfSubmarine;
  }

  /**
   * override the hashcode method.
   *
   * @return the hashcode of the object
   */
  @Override
  public int hashCode() {

    return Objects.hash(numOfBattleShip, numOfCruiser, numOfDestroyer, numOfSubmarine);
  }
}
