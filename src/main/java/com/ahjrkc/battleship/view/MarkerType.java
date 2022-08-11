package com.ahjrkc.battleship.view;

/**\
 * <p>This enum contains the markers for our game board. As the player and CPU make a move, the following
 * game actions will be taken:</p>
 * <ul>
 *   <li>if the selected index contains a part of a ship, the enum HIT will be added to that index.</li>
 *   <li>if the selected index DOES NOT contain a ship, the enum MISS will be added to that index.</li>
 *   <li>if a ship is sunk, any indexes surrounding that ship with the enum HIT will be replaced with SINK.</li>
 * </ul>
 */

public enum MarkerType {
  MISS('\u274C'),
  HIT('\u24BD'),
  SINK('\u29C5'),
  SHIP('\u8239'),
  NONE('\uFE4C');
  private final char symbol;

  MarkerType(char symbol) {
    this.symbol = symbol;
  }

  public char getSymbol() {
    return symbol;
  }


}
