package com.ahjrkc.battleship.model;

import java.util.ArrayList;

public enum ShipType {
    // General Rule: Enums should not have a mutable state.
    // Dont store location of ships to enum, dont have diff ship type for two players
    // This enum should go into it's own file
    CARRIER(5, "carrier"),
    BATTLESHIP(4, "battleship"),
    DESTROYER(3, "destroyer"),
    SUBMARINE(3, "submarine"),
    PATROL_BOAT(2, "patrol boat");
    // change to size only
    public final String name;

  public final int spacesFilled;

  // work for 8/9

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


