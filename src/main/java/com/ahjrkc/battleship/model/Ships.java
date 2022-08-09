package com.ahjrkc.battleship.model;

import java.util.ArrayList;

public enum Ships {

  CARRIER(5) ,
  BATTLESHIP(4),
  DESTROYER(3),
  SUBMARINE(3),
  PATROL_BOAT(2);

  private final int spacesFilled;
  public int hitCount;
  public static ArrayList<int[]> Coordinates;

  Ships(int spacesFilled){
    this.spacesFilled = spacesFilled;
  }

  // work for 8/9
  public int getSpacesFilled() {
    return spacesFilled;
  }

  // work for 8/9
  public int[] placementCheck(int row, int col, ShipDirection direction){
    throw new UnsupportedOperationException("Not yet implemented");
  }

  //work on 8/9
  public int hitCounter(){
    // algorithm
    // hitCount++;
    return hitCount;
  }
}
