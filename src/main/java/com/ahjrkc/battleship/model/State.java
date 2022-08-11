package com.ahjrkc.battleship.model;

/**
 *<p>This Enum is to determine the state in which the game is in at all times.</p>
 * <ul>
 *   <li>PLACEMENT: this state is for the beginning of the game when the player and cpu ships are being placed</li>
 *   <li>PLAYER_MOVEMENT: this state is for when the player is taking shots at the cpu or essentially when it is the players turn</li>
 *   <li>CPU_MOVEMENT: this state is for when the cpu is taking shots ate the player or essentially it is the cpu turn</li>
 *   <li>PLAYER_WIN: this state is to determine the game has ended with the player being the winner</li>
 *   <li>CPU_WIN: this state is to determine the game has ended with the cpu being the winner</li>
 * </ul>
 */

public enum State {

  PLACEMENT,
  PLAYER_MOVEMENT,
  CPU_MOVEMENT,
  PLAYER_WIN {
    @Override
    public boolean isTerminal() {
      return true;
    }
  },
  CPU_WIN {
    @Override
    public boolean isTerminal() {
      return true;
    }
  };

  public boolean isTerminal() {
    return false;
  }
}
