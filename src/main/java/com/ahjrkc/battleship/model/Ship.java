package com.ahjrkc.battleship.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>The Ship class is used to instantiate a new ship of each type for the player and the computer. In the
 * beginning of the game, the fleet of ships are created when the user and computer set their ships on the board.</p>
 */

public class Ship {

  ShipType type;

  public List<int[]> placement = new ArrayList<>();

  public List<Boolean> hitTracker = new ArrayList<>();

  /**
   * Creates a new Ship of each type for the player and computer when a new placement is established
   * the Game class.
   *
   * @param type      specifies the type of ship being placed.
   * @param placement these are the coordinates specified either by the player or randomly by
   *                  the computer to designate the ship's placement on the board.
   */
  public Ship(ShipType type, ArrayList<int[]> placement) {
    this.type = type;
    this.placement = placement;
    this.hitTracker = new ArrayList<>();
    for (int[] place : placement) {
      hitTracker.add(false);
    }
  }

  /**
   * This method checks if a shot has hit a ship by iterating through each ship's coordinates
   * to find possible matches. It changes the boolean at the corresponding index of the
   * hitTracker ArrayList if a match is found.
   * @param shot an array of integer coordinates in the order of row and column.
   * @return a boolean
   */
  public boolean processEachHit(int[] shot) {
    for (int i = 0; i < placement.size(); i++) {
      if (Arrays.equals(placement.get(i), shot)) {
        hitTracker.set(i, true);
        return true;
      }
    }
    return false;
  }

  /**
   * This method iterates through an individual ship placement to see if all sections in ship
   * hitTracker field were hit(all true), returns boolean of whether that ship has been sunk.
   * @return a boolean
   */
  public boolean isSunk() {
    for (Boolean section : hitTracker) {
      if (section.equals(false)) {
        return false;
      }
    }
    return true;
  }


  public ShipType getType() {
    return type;
  }

  public void setType(ShipType type) {
    this.type = type;
  }

  public List<int[]> getPlacement() {
    return placement;
  }

  public void setPlacement(ArrayList<int[]> placement) {
    this.placement = placement;
  }

  public List<Boolean> getHitTracker() {
    return hitTracker;
  }

  public void setHitTracker(ArrayList<Boolean> hitTracker) {
    this.hitTracker = hitTracker;
  }

}
