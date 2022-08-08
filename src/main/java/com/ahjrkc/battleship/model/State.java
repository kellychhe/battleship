package com.ahjrkc.battleship.model;

public enum State {

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

  public boolean isCurrentTurn(){return false;};

  public State nextMove(){return null;}

  public State winState(){return null;}
}
