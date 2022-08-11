package com.ahjrkc.battleship.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>This board class is responsible for the methods that allow gameplay, accounting for all hits,
 * misses and placements</p>
 */
public class Board {

  private final ArrayList<int[]> misses = new ArrayList<>();
  private final List<Ship> ships = new ArrayList<>();

  /**
   * <p>This method created the coordinates for an individual ship. It is invoked through game.</p>
   * @param type - passed in based on the type of ship being placed
   * @param placement - generated from user input when prompted for coordinates
   */
  public void placeShip(ShipType type, ArrayList<int[]> placement) {
    ships.add(new Ship(type, placement));
  }

  /**
   * <p> This method checks for any placement conflicts that might occur when the user enters
   * coordinates. This is invoked in the game class before further action is taken with the coordinates.
   * Possible conflicts include placement out of bounds of the board and ships overlapping.</p>
   * @param placement checks the entire array (board)
   * @return This method returns a boolean. True idf there is a conflict, and false if there is not.
   */
  public boolean isConflict(ArrayList<int[]> placement) {
    ArrayList<int[]> allShipPlacements = getAllShipPlacements();
    // do any coordinates overlap with other ships already placed
    for (int[] place : placement) {
      for (int num : place) {
        if (num < 0 || num >= 10) {
          return true;
        }
      }
      for (int[] currentPlace : allShipPlacements) {
        if (Arrays.equals(place, currentPlace)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * <p>This method delegates work to the Ship class in order to be accessed by the Game class (controller).</p>
   * @param coordinates - user entered coordinates from game class methods
   * @return Returns a boolean.
   */
  public boolean processEachHit(int[] coordinates) {
    boolean hit = false;
    for (Ship ship : ships) {
      if (ship.processEachHit(coordinates)) {
        hit = true;
        break;
      }
    }
    return hit;
  }

  /**
   * <p>Checks a ship to see if it has been sunk.</p>
   * @return An ArrayList of ship(s) that has been sunk.
   */
  public ArrayList<ShipType> isSunk() {
    ArrayList<ShipType> sunkShips = new ArrayList<>();
    for(Ship ship : ships){
      if(ship.isSunk()){
        sunkShips.add(ship.getType());
      }
    }
    return sunkShips;
  }

  /**
   * <p>This method grabs all coordinates for each ship and places them into an
   * ArrayList of integer arrays.</p>
   * @return Returns an ArrayList of integer arrays containing all coordinates that ships are placed at.
   */
  public ArrayList<int[]> getAllShipPlacements() {
    ArrayList<int[]> allShipPlacements = new ArrayList<>();
    for (Ship ship : ships) {
      allShipPlacements.addAll(ship.getPlacement());
    }
    return allShipPlacements;
  }

  /**
   * <p>This method checks whether the entire fleet for the player or cpu has been sunk.</p>
   * @return boolean return, true if all ships have been sunk (end game indicator) or false if they haven't.
   */
  public boolean areAllShipsSunk() {
    for (Ship ship : ships) {
      if (!ship.isSunk()) {
        return false;
      }
    }
    return true;
  }

  /**
   * <p>This method takes a shot that was taken by the cpu or player, and if the shot does not hit a ship the shot is
   * added to the board's misses array.</p>
   * @param shot shot an array of integers that represents coordinates.
   */
  public void addMiss(int[] shot) {
    misses.add(shot);
  }

  /**
   * <p>This method accumulates all moves, hits or misses, for that player into and ArrayList of "allShots"
   * and iterates through them to determine if that shot has already been made.</p>
   * @param shot an array of integers that represents coordinates.
   * @return Returns a boolean indicating true if the shot has been taken, and false if it hasn't.
   */
  public boolean isRepeatShot(int[] shot) {
    List<int[]> allShots = getAllHits();
    allShots.addAll(misses);
    for (int[] allShot : allShots) {
      if (Arrays.equals(shot, allShot)) {
        return true;
      }
    }
    return false;
  }

  /**
   * <p>This method iterates through all ships to created an overall list of all hits.</p>
   * @return Returns an ArrayList of all moves that resulted in a hit.
   */
  public ArrayList<int[]> getAllHits() {
    ArrayList<int[]> allHits = new ArrayList<>();
    for (Ship ship : ships) {
      for (int i = 0; i < ship.placement.size(); i++) {
        if (ship.hitTracker.get(i)) {
          allHits.add(ship.placement.get(i));
        }
      }
    }
    return allHits;
  }

  /**
   * <p>This method returns the coordinates of sunken ships.</p>
   * @return Returns an ArrayList of coordinates for all sunken ships.
   */
  public ArrayList<int[]> getCoordinatesOfSunk() {
    ArrayList<int[]> sunkCoordinates = new ArrayList<>();
    for (Ship ship : ships) {
      if (ship.isSunk()){
        sunkCoordinates.addAll(ship.getPlacement());
      }
    }
    return sunkCoordinates;
  }

  public ArrayList<int[]> getMisses() {
    return misses;
  }
}