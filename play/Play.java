package edu.neu.ccs.cs5004.assignment5.battleship.play;

import edu.neu.ccs.cs5004.assignment5.battleship.controller.Controller;
import edu.neu.ccs.cs5004.assignment5.battleship.model.Model;

import java.io.IOException;

/**
 * represent the class to start the game.
 */

public class Play {

  /**
   * main method to start the game.
   *
   * @param args input
   * @throws IOException exception to catch
   */

  public static void main(String[] args) throws IOException {
    Controller battleShipController = Controller.createController();
    battleShipController.addModel(Model.createModel());
    battleShipController.startGame();
  }
}
