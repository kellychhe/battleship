package com.ahjrkc.battleship.model;

import java.util.ArrayList;

public class Ships {

  ShipType type;

  ArrayList<int[]> placement;

  ArrayList<Boolean> hitTracker;

  public Ships(ShipType type, ArrayList<int[]> placement) {
    this.type = type;
    this.placement = placement;
    this.hitTracker = new ArrayList<>();
    for (int[] place : placement) {
      hitTracker.add(false);
    }
  }
  // leave orientation to the controller

  public boolean processEachHit(int row, int col) {
    for (int i = 0; i < placement.size(); i++) {
      int[] section = placement.get(i);
      if (section[0] == row && section[1] == col) {
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

  public ArrayList<int[]> getPlacement() {
    return placement;
  }

  public void setPlacement(ArrayList<int[]> placement) {
    this.placement = placement;
  }

  public ArrayList<Boolean> getHitTracker() {
    return hitTracker;
  }

  public void setHitTracker(ArrayList<Boolean> hitTracker) {
    this.hitTracker = hitTracker;
  }

  // add toString
}
