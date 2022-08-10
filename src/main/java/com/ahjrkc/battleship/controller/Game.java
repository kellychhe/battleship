package com.ahjrkc.battleship.controller;

import com.ahjrkc.battleship.model.Board;
import com.ahjrkc.battleship.model.ShipDirection;
import com.ahjrkc.battleship.model.ShipType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * <p>The <strong>Game Class</strong> serves as </p>
 */
public class Game {

  public static final int NUM_OF_ROWS = 10;
  public static final int NUM_OF_COLS = 10;
  // Do not delete below, helps with filtering user coordinates.
  private static final Pattern INPUT_SPLITTER = Pattern.compile("\\D+");

  public int[] shot;
  public ShipType[] fleet = new ShipType[]{
      ShipType.CARRIER,
      ShipType.BATTLESHIP,
      ShipType.DESTROYER,
      ShipType.SUBMARINE,
      ShipType.PATROL_BOAT
  };

  public String playerName;
  public ShipDirection[] directions = new ShipDirection[]{
      ShipDirection.NORTH,
      ShipDirection.SOUTH,
      ShipDirection.EAST,
      ShipDirection.WEST
  };
  // put all directions together in an array (hard code)

  Board player = new Board();
  Board cpu = new Board();

  public void greetPlayer() throws IOException {
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Ahoy there Matey! What is your name?");
    playerName = buffer.readLine().trim();
    System.out.printf("Welcome to Battleship, %s", playerName);
  }

  // get the ship placement from reader :D
  public void playerSetShips() throws IOException {

    for (ShipType ship : fleet) {
      boolean placementSuccess = false;

      System.out.printf("Okay %1$s, it's time to place your %2$s on the board!",
            playerName, ship.getName());

      while (!placementSuccess) {
        int[] coordinates = grabUserCoordinates();
        for (ShipDirection direction : directions) {
          ArrayList<int[]> placement = createPlacement(ship, coordinates, direction);
          if (!player.isConflict(placement)){
            player.placeShip(ship, placement);
            placementSuccess = true;
          }
        }
        if (!placementSuccess) {
          System.out.printf("Sorry %s, that is not a valid place for your ship :(", playerName);
        }
      }
      // conditional: if ship is not placed, then ask for coordinates again
    }
    // create array based on direction -> loop through direction and run each direction method to create a placement array
    // use isConflict to check if that placement is valid so it doesn't overlap
        // if true, change direction and create a new array
        // if false, placeShip (Ships class)
    // check
    // for loop => loops through ships in fleet
      // do/while prompt for userCoordinates
      // run isConflict (once false, break out of while loop, continue with for loop to begin with next ship
        // while isConflict = true, prompt user coordinates (do we need?)
      // outside of while loop => placeShip method (
  }

  public ArrayList<int[]> createPlacement(ShipType ship, int[] coordinates, ShipDirection Direction) {
    throw new UnsupportedOperationException("Not yet implemented");
  }
  // Create a method createPlacement(ShipType ship, int[] coordinates, ShipDirection Direction)
  // Switch cases => based on direction
  // return placement array

  // grab coordinates from user and return shot to be used in other methods
  public int[] grabUserCoordinates() throws IOException {
    Reader reader = new InputStreamReader(System.in);
    BufferedReader buffer = new BufferedReader(reader);
    do {
      System.out.println();
      System.out.printf("Ay ay %s, Please enter your coordinates.", playerName);
      System.out.println();
      System.out.println("Coordinates must be two numbers between 0-9 separated by a comma.");
      String coordinates = buffer.readLine().trim();
      shot = INPUT_SPLITTER
          .splitAsStream(coordinates)
          .map(String::trim)
          .filter((s) -> !s.isEmpty())
          .mapToInt(Integer::parseInt)
          .filter((value) -> value >= 0 && value < 10)
          .limit(2)
          .toArray();
    } while (shot.length != 2);

    return shot;
  }

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
