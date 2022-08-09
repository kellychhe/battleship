package com.ahjrkc.battleship.model;

/**
 * <p>This enum dictates the direction in which a user can place their ship. North and West represent
 * negative values since they place against the array index (subtract). East and West remain positive.
 * These values will be used when placing ships during the game set-up.</p>
 */
public enum ShipDirection {
  NORTH(-1),
  SOUTH(1),
  EAST(1),
  WEST(-1);

  private final int sign;

  ShipDirection(int sign) {
    this.sign = sign;
  }

  public int getSign() {
    return sign;
  }


}
