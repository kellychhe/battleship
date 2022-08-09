package com.ahjrkc.battleship.model;

import java.util.ArrayList;
import java.util.Collection;

public interface Ships {

  Collection<ShipDirection> availableDirection(int row, int col, ShipType type);

  boolean isNorthAvailable(int row, int col, ShipType type);

  boolean isSouthAvailable( int col, ShipType type);

  boolean isWestAvailable(int row, ShipType type);

  boolean isEastAvailable(int row, ShipType type);
  void addPosition(int row, int col, ShipDirection direction);

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
