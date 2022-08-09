package com.ahjrkc.battleship.model;

import com.ahjrkc.battleship.model.exceptions.IllegalPlacementException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Ships {

  Collection<ShipDirection> availableDirection(int row, int col, ShipType type);

  boolean isNorthAvailable(int row, int col, ShipType type);

  static boolean isSouthAvailable( int col, ShipType type){
    int shipCapacity = type.position.size();
    if(shipCapacity + col * ShipDirection.SOUTH.getSign() > 10){
      return false;
    } else{
      return true;
    }
  }

  static boolean isWestAvailable(int row, ShipType type){
    int shipCapacity = type.position.size();
    if(shipCapacity + row * ShipDirection.WEST.getSign() < 0){
      return false;
    } else{
      return true;
    }
  }

  static boolean isEastAvailable(int row, ShipType type){
    int shipCapacity = type.position.size();
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
    PLAYER_CARRIER(new ArrayList<>(5)),
    PLAYER_BATTLESHIP(new ArrayList<>(4)),
    PLAYER_DESTROYER(new ArrayList<>(3)),
    PLAYER_SUBMARINE(new ArrayList<>(3)),
    PLAYER_PATROL_BOAT(new ArrayList<>(2)),
    COMPUTER_CARRIER(new ArrayList<>(5)),
    COMPUTER_BATTLESHIP(new ArrayList<>(4)),
    COMPUTER_DESTROYER(new ArrayList<>(3)),
    COMPUTER_SUBMARINE(new ArrayList<>(3)),
    COMPUTER_PATROL_BOAT(new ArrayList<>(2));

    public final ArrayList<int[]> position;

    ShipType(ArrayList<int[]> position){
      this.position = position;
    }
    public ArrayList<int[]> getPosition() {
      return position;
    }
  }

}
