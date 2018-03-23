package edu.neu.ccs.cs5004.assignment5.battleship.view;

import edu.neu.ccs.cs5004.assignment5.battleship.model.Model;

/**
 * .
 * represent the view component
 */

public interface View {

  /**
   * .
   * create a battle ship game view object
   *
   * @return a new battle ship game view object
   */

  static View createView() {
    return new BattleShipGameView();
  }

  /**
   * .
   * update the view in game mode
   *
   * @param observable the object that needs observe
   */

  void updateGameView(Model observable);

  /**
   * .
   * update the view in debug mode
   *
   * @param observable the object that needs observe
   */

  void updateDebugView(Model observable);
}
