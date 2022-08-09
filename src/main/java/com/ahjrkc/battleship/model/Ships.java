package com.ahjrkc.battleship.model;

import com.ahjrkc.battleship.model.exceptions.IllegalPlacementException;
import java.util.ArrayList;
import java.util.Collection;

public interface Ships {

  static Collection<ShipDirection> availableDirection(int row, int col, ShipType type){
    Collection<ShipDirection> validDirections = new ArrayList<>();
    if (isNorthAvailable(col, type)){
      validDirections.add(ShipDirection.NORTH);
    } else if (isSouthAvailable(col, type)){
      validDirections.add(ShipDirection.SOUTH);
    } else if (isWestAvailable(row, type)){
      validDirections.add(ShipDirection.WEST);
    } else if (isEastAvailable(row, type)){
      validDirections.add(ShipDirection.EAST);
    } else {
      throw new IllegalPlacementException("Ship can not be placed here, please try again.");
    }
    return validDirections;
  }

  static boolean isNorthAvailable( int col, ShipType type){
    int shipCapacity = type.getSpacesFilled();
    if(shipCapacity + col * ShipDirection.NORTH.getSign() < 0){
      return false;
    } else{
      return true;
    }
  }

  static boolean isSouthAvailable( int col, ShipType type){
    int shipCapacity = type.getSpacesFilled();
    if(shipCapacity + col * ShipDirection.SOUTH.getSign() > 10){
      return false;
    } else{
      return true;
    }
  }

  static boolean isWestAvailable(int row, ShipType type){
    int shipCapacity = type.getSpacesFilled();
    if(shipCapacity + row * ShipDirection.WEST.getSign() < 0){
      return false;
    } else{
      return true;
    }
  }

  static boolean isEastAvailable(int row, ShipType type){
    int shipCapacity = type.getSpacesFilled();
    if(shipCapacity + row * ShipDirection.EAST.getSign() > 10){
      return false;
    } else{
      return true;
    }
  }
  void addPosition(int row, int col, ShipDirection direction);

  //work on 8/9
//  public int hitCounter(){
//    // algorithm
//    // hitCount++;
//    return hitCount;
//  }
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
