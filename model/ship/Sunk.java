package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

import java.util.Objects;

/**
 * .
 * Represents the result that the ship isCellSunk
 */

public class Sunk implements AttackResult {

  /**
   * .
   * constructor of sink class
   */

  private String status;

  public Sunk() {
    this.status = "isCellSunk";
  }

  /**
   * .
   * get the value of status field
   *
   * @return the status of class
   */

  public String getStatus() {
    return this.status;
  }

  /**
   * .
   * get the attack result
   *
   * @return new sink object
   */

  @Override
  public AttackResult getResult() {
    return new Sunk();
  }

  /**
   * .
   * compare object with instance of sink class
   *
   * @param object the object to be compared with specific instance of this class
   * @return true if the two object are the same, false otherwise
   */

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Sunk sink = (Sunk) object;
    return Objects.equals(status, sink.status);
  }

  /**
   * .
   * calculate hash code
   *
   * @return hash code value of specific instance of this class
   */

  @Override
  public int hashCode() {

    return Objects.hash(status);
  }

  /**
   * .
   * represent information in this object as a string
   *
   * @return string to represent the information in this object
   */

  @Override
  public String toString() {
    return "Sunk{"
        + "status='" + status + '\''
        + '}';
  }
}
