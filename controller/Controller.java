package edu.neu.ccs.cs5004.assignment5.battleship.controller;

import edu.neu.ccs.cs5004.assignment5.battleship.model.Model;

import java.io.IOException;

/**
 * Controller interface.
 */
public interface Controller {
  /**
   * createController method.
   *
   * @return a battleShipController
   */
  static Controller createController() {
    return new BattleShipGameController();
  }

  /**
   * startGame method.
   *
   * @throws IOException when encounter exception
   */
  void startGame() throws IOException;

  /**
   * addModel method.
   *
   * @param model input model
   */
  void addModel(Model model);
}
