package com.ahjrkc.battleship.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {

  public ArrayList<int[]> misses;
  public ArrayList<Ships> ships;

  // Build constructor or get beat up



  public void placeShip(ShipType type, ArrayList<int[]> placement) {
    // construct new ship and add to array of ship

    ships.add(new Ships(type, placement));

  }

  public boolean isConflict(ArrayList<int[]> ships, ArrayList<int[]> placement) {
    // do any coordinates overlap with other ships already placed
    return false;
  }

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
    ArrayList<int[]> allShots = new ArrayList<>();
    // if the coordinates is in the misses array or is a coordinate that was already hit return true
    for(Ships ship : ships){
      for(int i = 0; i < ship.placement.size() ; i++ ){
        if(ship.hitTracker.get(i)){
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