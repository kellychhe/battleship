package com.ahjrkc.battleship.model;

import java.util.ArrayList;

public class Ships {
  public int hitCount;
  public static ArrayList<int[]> Coordinates;

  public ShipDirection[] availableDirection(int row, int col, ShipType type){
    throw new UnsupportedOperationException("Not yet implemented");
  }

  public boolean isNorthAvailable( int col, ShipType type){
    int shipCapacity = type.getSpacesFilled();
    if(shipCapacity + col * ShipDirection.NORTH.getSign() < 0){
      return false;
    } else{
      return true;
    }
  }

  public boolean isSouthAvailable( int col, ShipType type){
    int shipCapacity = type.getSpacesFilled();
    if(shipCapacity + col * ShipDirection.SOUTH.getSign() > 10){
      return false;
    } else{
      return true;
    }
  }

  public boolean isWestAvailable(int row, ShipType type){
    int shipCapacity = type.getSpacesFilled();
    if(shipCapacity + row * ShipDirection.WEST.getSign() < 0){
      return false;
    } else{
      return true;
    }
  }

  public boolean isEastAvailable(int row, ShipType type){
    int shipCapacity = type.getSpacesFilled();
    if(shipCapacity + row * ShipDirection.EAST.getSign() > 10){
      return false;
    } else{
      return true;
    }
  }
  public void addPosition(int row, int col, ShipDirection direction){

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
  public enum ShipType {
    CARRIER(5) ,
    BATTLESHIP(4),
    DESTROYER(3),
    SUBMARINE(3),
    PATROL_BOAT(2);

    public final int spacesFilled;

    ShipType(int spacesFilled){
      this.spacesFilled = spacesFilled;
    }

    // work for 8/9
    public int getSpacesFilled() {
      return spacesFilled;
    }


  }
}
