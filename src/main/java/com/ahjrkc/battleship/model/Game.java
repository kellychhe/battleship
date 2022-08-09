package com.ahjrkc.battleship.model;

import java.util.ArrayList;

public class Game {

  public static final int NUM_OF_ROWS = 10;
  public static final int NUM_OF_COLS = 10;

  public ArrayList<int[]> miss = new ArrayList<>();
  public ArrayList<int[]> hits = new ArrayList<>();
  public ArrayList<int[]> sink = new ArrayList<>();

  // enum for move types

  // enum for ship types

  // enum for direction

  // nested Enum for state

  // Player one move

  // cpu move

  // player win

  // cpu win

  // Have a throws clause for IllegalPlacementException (extends IllegalArgumentException (checked)
  // Have a throws clause for GameOverException (extends IllegalStateException) (checked)
}
