package com.ahjrkc.battleship.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>This board class is responsible for the methods that allow gameplay, accounting for all hits,
 * misses and placements</p>
 * <ul>
 *   <li>isConflict: this method checks for the two possible placement conflicts.
 *   The possible conflicts being placement out of bounds of the board and ships overlapping</li>
 *
 *   <li>getAllShipPlacements: grabs all coordinates for each ship and places them into and
 *   ArrayList of integers</li>
 *
 *   <li>areAllShipsSunk: iterates through all ships on board and invokes isSunk method from ships class.
 *   This is to determine if all ships for that board instance/player are sunk.</li>
 *
 *   <li>addMiss: when a shot is taken by the cpu or player, if the shot does not hit a ship the shot is
 *   , the miss is added to the board's misses array</li>
 *
 *   <li>isRepeatShot: accumulates all moves, hits or misses, for that player into and ArrayList of "allShots"
 *   and iterates through them to determine if that shot has already been made.</li>
 * </ul>
 */
public class Board {

  // change to general, instance type can stay the same
  private List<int[]> misses = new ArrayList<>();
  private List<Ship> ships = new ArrayList<>();

  public void placeShip(ShipType type, ArrayList<int[]> placement) {
    // construct new ship and add to array of ship

    ships.add(new Ship(type, placement));

  }

  // nick approved
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

  public ArrayList<int[]> getAllShipPlacements() {
    ArrayList<int[]> allShipPlacements = new ArrayList<>();

    for (Ship ship : ships) {
      allShipPlacements.addAll(ship.getPlacement());
    }
    return allShipPlacements;
  }

//  public boolean isShipInbounds(){
//
//  }

  public boolean areAllShipsSunk() {
    // check ships for isSunk
    // if a false is hit stop
    for (Ship ship : ships) {
      if (!ship.isSunk()) {
        return false;
      }
    }
    return true;
  }

  public void addMiss(int[] shot) {
    // when player shoots and misses store the miss so coordinates
    // can't be selected again (you're welcome user)
    misses.add(shot);

  }

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

  public ArrayList<int[]> getCoordinatesOfSunk() {
    ArrayList<int[]> sunkCoordinates = new ArrayList<>();
    for (Ship ship : ships) {
      if (ship.isSunk()){
        sunkCoordinates.addAll(ship.getPlacement());
      }
    }
    return sunkCoordinates;
  }

}