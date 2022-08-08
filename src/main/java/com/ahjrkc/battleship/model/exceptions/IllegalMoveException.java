package com.ahjrkc.battleship.model.exceptions;

public class IllegalMoveException extends IllegalArgumentException {

  // when player tries hitting ship that has already been sunk
  
  public IllegalMoveException(String message){
    super(message);
  }

}
