package com.ahjrkc.battleship.controller;

import com.ahjrkc.battleship.model.Board;
import com.ahjrkc.battleship.model.ShipType;
import java.util.ArrayList;

public class Game {

  public static final int NUM_OF_ROWS = 10;
  public static final int NUM_OF_COLS = 10;

  public int[] shot;
  public ShipType[] fleet;
  // loop through ShipType array to check that all ships are placed for both player and cpu

  Board player = new Board();
  Board cpu = new Board();

  // get the ship placement from reader :D

  // use do while loop to keep coordinates in bounds, repeat prompting if they dont get it

  // check isConflict(Board class) for placement, if it is false place the ship(Board Class)

  // repeat until we've gotten through all ships from player
  // do same for computer w/ randomizer

  // change state to the first players move

  // prompt reader for first shot (coordinates)

  // process each hit(Ships Class) on the cpu to see if cpu was hit
    // if it returns true run areAllShipsSunk (Board Class), then REPEAT_TURN(State) for player

  // if false run addMiss(Board Class) for player

  // Then change state to CPU_TURN(State) :)



  // Have a throws clause for IllegalPlacementException (extends IllegalArgumentException (checked)
  // Have a throws clause for GameOverException (extends IllegalStateException) (checked)
}
