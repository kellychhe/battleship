package com.ahjrkc.battleship.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

  public ArrayList<int[]> misses = new ArrayList<>();
  public ArrayList<Ships> ships = new ArrayList<>();

  // Build constructor or get beat up


  public void placeShip(ShipType type, ArrayList<int[]> placement) {
    // construct new ship and add to array of ship

    ships.add(new Ships(type, placement));

  }

  public boolean isConflict(ArrayList<int[]> placement) {
    ArrayList<int[]> allShipPlacements = getAllShipPlacements();
    // do any coordinates overlap with other ships already placed
    for (int[] place : placement) {
      for (int num : place) {
        if (num < 0 || num > 10) {
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

  private ArrayList<int[]> getAllShipPlacements() {
    ArrayList<int[]> allShipPlacements = new ArrayList<>();

    for (Ships ship : ships) {
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
    for (Ships ship : ships) {
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
    List<int[]> allShots = new ArrayList<>();
    // if the coordinates is in the misses array or is a coordinate that was already hit return true
    for (Ships ship : ships) {
      for (int i = 0; i < ship.placement.size(); i++) {
        if (ship.hitTracker.get(i)) {
          allShots.add(ship.placement.get(i));
        }
      }
    }

    allShots.addAll(misses);

    for (int[] allShot : allShots) {
      if (Arrays.equals(shot, allShot)) {
        return true;
      }
    }
    return false;
  }

}