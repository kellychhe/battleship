package com.ahjrkc.battleship.model;

public enum State {

  // game begins as user placing ship (computer can place ships first or after)

  // first move (computer or user)

  // five states: placement, movement, repeat turns (if hit), player winner, cpu winner

  PLAYER_MOVE{
    @Override
    public boolean isCurrentTurn(){return true;};

    @Override
    public State nextMove(){return COMPUTER_MOVE;}

    @Override
    public State winState(){return PLAYER_WIN;}
  },
  COMPUTER_MOVE{
    @Override
    public boolean isCurrentTurn(){return true;};

    @Override
    public State nextMove(){return PLAYER_MOVE;}

    @Override
    public State winState(){return COMPUTER_WIN;}
  },
  PLAYER_WIN,
  COMPUTER_WIN;

  private static final String END_GAME =
      "Game Over: No additional moves can be made. Play again or close the application.";

  // format to include incorrect coordinators when player method is added (format string), correct to more formal error message
  public static final String ILLEGAL_PLACEMENT =
      "Ship can not be placed here, please try again.";

  public static final String ILLEGAL_MOVE =
      "Move is either out of bounds of playing grid or on ship that has already been sunk, please select new coordinates";

  public boolean isCurrentTurn(){return false;};

  public State nextMove(){return null;}

  public State winState(){return null;}
}
