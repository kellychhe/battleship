package com.ahjrkc.battleship.model.exceptions;

/**
 * <p>The GameOverException is thrown if more moves are attempted after game play has ended.</p>
 */
public class GameOverException extends IllegalStateException {

  public GameOverException() {
  }

  public GameOverException(String message) {
    super(message);
  }

  public GameOverException(String message, Throwable cause) {
    super(message, cause);
  }

  public GameOverException(Throwable cause) {
    super(cause);
  }
}
