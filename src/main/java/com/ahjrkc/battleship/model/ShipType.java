package com.ahjrkc.battleship.model;

/**
 * <p>This enum contains the five different ships in our game. Each Ship has a size that is not mutable.
 * The enum also contains a string version of their name.</p>
 *
 */

public enum ShipType {
    CARRIER(5, "carrier"),
    BATTLESHIP(4, "battleship"),
    DESTROYER(3, "destroyer"),
    SUBMARINE(3, "submarine"),
    PATROL_BOAT(2, "patrol boat");

    public final String name;
    public final int spacesFilled;

    ShipType(int spacesFilled, String name){
      this.spacesFilled = spacesFilled;
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public int getSpacesFilled() {
    return spacesFilled;
  }
  }


