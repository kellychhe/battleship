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

  // game begins as user placing ship (computer can place ships first or after)

  // first move (computer or user)

  // five states: placement, movement, repeat turns (if hit), player winner, cpu winner

  PLACEMENT,
  PLAYER_MOVEMENT,
  CPU_MOVEMENT,
  // have methods in state do work = example of OOP
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

//  PLAYER_MOVE{
//    @Override
//    public boolean isCurrentTurn(){return true;};
//
//    @Override
//    public State nextMove(){return COMPUTER_MOVE;}
//
//    @Override
//    public State winState(){return PLAYER_WIN;}
//  },
//  COMPUTER_MOVE{
//    @Override
//    public boolean isCurrentTurn(){return true;};
//
//    @Override
//    public State nextMove(){return PLAYER_MOVE;}
//
//    @Override
//    public State winState(){return COMPUTER_WIN;}
//  },
//  PLAYER_WIN,
//  COMPUTER_WIN;

  private static final String END_GAME =
      "Game Over: No additional moves can be made. Play again or close the application.";

  // format to include incorrect coordinators when player method is added (format string), correct to more formal error message
  public static final String ILLEGAL_PLACEMENT =
      "Ship can not be placed here, please try again.";

  public static final String ILLEGAL_MOVE =
      "Move is either out of bounds of playing grid or on ship that has already been sunk, please select new coordinates";

  public boolean isTerminal() {
    return false;
  }
}
