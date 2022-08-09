package com.ahjrkc.battleship.model;

import java.util.ArrayList;
import java.util.Collection;

public interface Ships {

  Collection<ShipDirection> availableDirection(int row, int col, ShipType type);

  boolean isNorthAvailable(int row, int col, ShipType type);

  boolean isSouthAvailable(int row, int col, ShipType type);

  boolean isWestAvailable(int row, int col, ShipType type);

  boolean isEastAvailable(int row, int col, ShipType type);
  void addPosition(int row, int col, ShipDirection direction);

  public enum ShipType {
    PLAYER_CARRIER(new ArrayList<>(5), "carrier"),
    PLAYER_BATTLESHIP(new ArrayList<>(4), "battleship"),
    PLAYER_DESTROYER(new ArrayList<>(3), "destroyer"),
    PLAYER_SUBMARINE(new ArrayList<>(3), "submarine"),
    PLAYER_PATROL_BOAT(new ArrayList<>(2), "patrol boat"),
    COMPUTER_CARRIER(new ArrayList<>(5), "carrier"),
    COMPUTER_BATTLESHIP(new ArrayList<>(4), "battleship"),
    COMPUTER_DESTROYER(new ArrayList<>(3), "destroyer"),
    COMPUTER_SUBMARINE(new ArrayList<>(3), "submarine"),
    COMPUTER_PATROL_BOAT(new ArrayList<>(2), "patrol boat");

    public final ArrayList<int[]> position;
    public final String name;

    ShipType(ArrayList<int[]> position, String name){
      this.position = position;
      this.name = name;
    }
    public ArrayList<int[]> getPosition() {
      return position;
    }

    public String getName() {
      return name;
    }
  }

}
