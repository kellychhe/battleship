package com.ahjrkc.battleship.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p></p>
 *<ul>
 *   <li>processEachHit: checks if the shot has hit a ship by iterating through each ships coordinates
 *   to find possible matches. It changes the boolean at the corresponding index of the
 *   hitTracker ArrayList if a match is found</li>
 *   <li>isSunk: Iterates through an individual ship placement to see if all sections in ship
 *   hitTracker field were hit(all true), returns boolean of whether or not that ship has been sunk.</li>
 *</ul>
 */

public class Ship {

  ShipType type;

  public List<int[]> placement = new ArrayList<>();

  public List<Boolean> hitTracker = new ArrayList<>();

  public Ship(ShipType type, ArrayList<int[]> placement) {
    this.type = type;
    this.placement = placement;
    this.hitTracker = new ArrayList<>();
    for (int[] place : placement) {
      hitTracker.add(false);
    }
  }
  // leave orientation to the controller

  public boolean processEachHit(int[] shot) {
    for (int i = 0; i < placement.size(); i++) {
      if (Arrays.equals(placement.get(i), shot)) {
        hitTracker.set(i, true);
        return true;
      }
    }
    return false;
    // using the boolean, we can react to it / do something with it
    // return true if hasnt
    // loop through all placements and check to see if any placements match row and col of the hit
    // if hit, update hitTracker, return true
    // return false
  }

  public boolean isSunk() {
    for (Boolean section : hitTracker) {
      if (section.equals(false)) {
        return false;
      }
    }
    return true;
    // loop through hit tracker
    // if all true, return true, else return false
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

  // add toString
}
