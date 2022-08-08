package com.ahjrkc.battleship.model;

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
  MISS('\u0058', Color.GREY),
  HIT('\u004F', Color.RED),
  SINK('\u0053', Color.GREEN);

  private final char symbol;
  private final Color color;

  MarkerType(char symbol, Color color) {
    this.symbol = symbol;
    this.color = color;
  }

  public char getSymbol() {
    return symbol;
  }

  public Color getColor() {
    return color;
  }

  public enum Color {
    GREY,
    RED,
    GREEN
  }
}
