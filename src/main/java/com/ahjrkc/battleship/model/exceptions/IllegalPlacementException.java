package com.ahjrkc.battleship.model.exceptions;

/**
 * <p>The IllegalPlacementException can be thrown if the user/player tries to
 * place a ship where one already exists (or close to it) as well as if the user/player attempts to
 * place a ship out of bounds.</p>
 */
public class IllegalPlacementException extends IllegalArgumentException {

  public IllegalPlacementException() {
  }

  public IllegalPlacementException(String s) {
    super(s);
  }

  public IllegalPlacementException(String message, Throwable cause) {
    super(message, cause);
  }

  public IllegalPlacementException(Throwable cause) {
    super(cause);
  }

}
