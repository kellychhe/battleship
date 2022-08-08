package com.ahjrkc.battleship.model;

public enum Ships {

  CARRIER(5) ,
  BATTLESHIP(4),
  DESTROYER(3),
  SUBMARINE(3),
  PATROL_BOAT(2);

  private final int spacesFilled;

  Ships(int spacesFilled){
    this.spacesFilled = spacesFilled;
  }

  public int getSpacesFilled() {
    return spacesFilled;
  }
}
