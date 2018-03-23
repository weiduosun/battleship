package edu.neu.ccs.cs5004.assignment5.battleship.view;

import edu.neu.ccs.cs5004.assignment5.battleship.model.Model;

/**
 * Represent the Printer class.
 */

public class ModelPrinter {
  private static final String ANSI_RESET = "\u001B[0m";
  private static final String ANSI_RED = "\u001B[31m";
  private static final String ANSI_GREEN = "\u001B[32m";
  private static final String ANSI_YELLOW = "\u001B[33m";
  private static final String ANSI_BLUE = "\u001B[34m";

  /**
   * Print the game mode information.
   *
   * @param model the model to be printed
   */

  public void gameModePrint(Model model) {

    System.out.println("\n----------------------FLEET MAP--------------------\n");

    printMyFleetMap(model);

    System.out.println("\n---------------------BATTLE MAP--------------------\n");

    printMyBattleMap(model);
  }

  /**
   * Print the debug mode information.
   *
   * @param model the model to be printed
   */

  public void debugModePrint(Model model) {

    System.out.println("\n---------------------YOUR FLEET MAP--------------------\n");

    printMyFleetMap(model);

    System.out.println("\n----------------------YOUR BATTLE MAP--------------------\n");

    printMyBattleMap(model);

    System.out.println("\n--------------------ENEMY'S FLEET MAP--------------------\n");

    printEnemyFleetMap(model);

    System.out.println("\n--------------------ENEMY'S BATTLE MAP--------------------\n");

    printEnmeyBattleMap(model);
  }

  /**
   * Print user's fleet map.
   *
   * @param model the model to be printed
   */

  private void printMyFleetMap(Model model) {
    for (int i = 0; i < model.getMyMap().getSize(); i++) {
      for (int j = 0; j < model.getMyMap().getSize(); j++) {

        if (model.getMyMap().getCell(i, j).getCellType().equals("openseacell")
            ) {
          System.out.print(ANSI_BLUE + "o    " + ANSI_RESET);
        } else if (model.getMyMap().getCell(i, j).getCellType().equals("gapcell")) {
          System.out.print(ANSI_YELLOW + "o    " + ANSI_RESET);
        } else if (model.getMyMap().getCell(i, j).getCellType().equals("specificshipcell")) {
          System.out.print("|    ");
        }
      }

      System.out.println("\n");
    }
  }

  /**
   * Print user's battle map.
   *
   * @param model the model to be printed
   */

  private void printEnemyFleetMap(Model model) {
    for (int i = 0; i < model.getEnemyMap().getSize(); i++) {
      for (int j = 0; j < model.getEnemyMap().getSize(); j++) {

        if (model.getEnemyMap().getCell(i, j).getCellType().equals("openseacell")
            ) {
          System.out.print(ANSI_BLUE + "o    " + ANSI_RESET);
        } else if (model.getEnemyMap().getCell(i, j).getCellType().equals("gapcell")) {
          System.out.print(ANSI_YELLOW + "o    " + ANSI_RESET);
        } else if (model.getEnemyMap().getCell(i, j).getCellType().equals("specificshipcell")) {
          System.out.print("|    ");
        }
      }

      System.out.println("\n");
    }
  }

  /**
   * Print user's battle map.
   *
   * @param model the model to be printed
   */

  private void printMyBattleMap(Model model) {
    for (int i = 0; i < model.getEnemyMap().getSize(); i++) {
      for (int j = 0; j < model.getEnemyMap().getSize(); j++) {

        if (model.getEnemyMap().getCell(i, j).getCellSunkStatus()) {
          System.out.print(ANSI_RED + "Sunk " + ANSI_RESET);
        } else if (model.getEnemyMap().getCell(i, j).isCellHit()
            && (model.getEnemyMap().getCell(i, j).getCellType().equals("gapcell")
            || model.getEnemyMap().getCell(i, j).getCellType().equals("openseacell"))) {
          System.out.print(ANSI_GREEN + "Miss " + ANSI_RESET);
        } else if (model.getEnemyMap().getCell(i, j).isCellHit()) {
          System.out.print(ANSI_YELLOW + "Hit  " + ANSI_RESET);
        } else {
          System.out.print(ANSI_BLUE + "o    " + ANSI_RESET);
        }
      }
      System.out.println("\n");
    }
  }

  /**
   * Print enemy's battle map.
   *
   * @param model the model to be printed
   */

  private void printEnmeyBattleMap(Model model) {
    for (int i = 0; i < model.getMyMap().getSize(); i++) {
      for (int j = 0; j < model.getMyMap().getSize(); j++) {

        if (model.getMyMap().getCell(i, j).getCellSunkStatus()) {
          System.out.print(ANSI_RED + "Sunk " + ANSI_RESET);
        } else if (model.getMyMap().getCell(i, j).isCellHit()
            && (model.getMyMap().getCell(i, j).getCellType().equals("gapcell")
            || model.getMyMap().getCell(i, j).getCellType().equals("openseacell"))) {
          System.out.print(ANSI_GREEN + "Miss " + ANSI_RESET);
        } else if (model.getMyMap().getCell(i, j).isCellHit()) {
          System.out.print(ANSI_YELLOW + "Hit  " + ANSI_RESET);
        } else {
          System.out.print(ANSI_BLUE + "o    " + ANSI_RESET);
        }
      }
      System.out.println("\n");
    }
  }

  /**
   * Override the toString method.
   *
   * @return the string of the object
   */
  @Override
  public String toString() {
    return "ModelPrinter{}";
  }
}
