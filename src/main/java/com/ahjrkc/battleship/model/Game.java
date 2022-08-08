package com.ahjrkc.battleship.model;

public class Game {

  private static final int NUM_OF_ROWS = 10;
  private static final int NUM_OF_COLS = 10;

  public void grid() {
    MarkerType[][] grid = new MarkerType[NUM_OF_ROWS][NUM_OF_COLS];
    for (int i = 0; i <= NUM_OF_ROWS; i++ ) {
      for (int j = 0; j <= NUM_OF_COLS; j++) {
        grid[i][j] = null;
      }
    }
  }
  // enum for move types

  // enum for ship types

  // enum for direction

  // nested Enum for state

  // Player one move

  // cpu move

  // player win

  // cpu win
}
