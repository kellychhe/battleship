package com.ahjrkc.battleship.model;

import java.util.ArrayList;

public class Board {

  public ArrayList<int[]> misses;
  public ArrayList<int[]> ships;

  // Build constructor or get beat up

  public void placeShip(ShipType type, ArrayList<int[]> placement){
    // construct new ship and add to array of ship
  }

  public boolean isConflict(ArrayList<int[]> ships, ArrayList<int[]> placement){
    // do any coordinates overlap with other ships already placed
    return false;
  }

  public boolean areAllShipsSunk(){
    // check ships for isSunk
    // check if hit arrays are full of trues and if so it is sunk
    // if a false is hit stop
    return false;
  }

  public void addMiss(int[] shot){
    // when player shoots and misses store the miss so coordinates can't be selected again (you're welcome user)
  }

  public boolean isRepeatShot(int[] shot){
    // if the coordinates is in the misses array or is a coordinate that was already hit return true
    return false;
  }

}
