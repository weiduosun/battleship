package edu.neu.ccs.cs5004.assignment5.battleship.model;

import edu.neu.ccs.cs5004.assignment5.battleship.view.View;

/**
 * Represents observable.
 */
public abstract class Observable {

  /**
   * .
   * add observer to a list of observers
   *
   * @param observer observer
   */

  public abstract void registerObserver(View observer);

  /**
   * .
   * remove observe from a list of observers
   *
   * @param observer observer
   */

  public abstract void removeObserver(View observer);

  /**
   * .
   * notify observer if a model was changed
   */

  public abstract void notifyObservers();
}
