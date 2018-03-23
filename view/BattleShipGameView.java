package edu.neu.ccs.cs5004.assignment5.battleship.view;

import edu.neu.ccs.cs5004.assignment5.battleship.model.Model;

/**
 * .
 * represent the battleshipgameview class
 */


public class BattleShipGameView implements View {

  /**
   * Update the view in game mode.
   *
   * @param observable the object that needs observe
   */

  @Override
  public void updateGameView(Model observable) {
    ModelPrinter printer = new ModelPrinter();
    printer.gameModePrint(observable);
  }

  /**
   * Update the view in debug mode.
   *
   * @param observable the object that needs observe
   */

  @Override
  public void updateDebugView(Model observable) {
    ModelPrinter printer = new ModelPrinter();
    printer.debugModePrint(observable);

  }
}
