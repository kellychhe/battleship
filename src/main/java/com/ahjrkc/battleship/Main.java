package com.ahjrkc.battleship;

import com.ahjrkc.battleship.controller.Game;
import com.ahjrkc.battleship.model.State;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    Game game = new Game(State.PLACEMENT);
    if (game.getState() == State.PLACEMENT) {
      game.greetPlayer();
      game.setShips(game.cpu);
      game.setShips(game.player);
    }
    while (!game.getState().isTerminal()) {
      game.setState(State.PLAYER_MOVEMENT);
      int[] coordinates = game.grabUserCoordinates();
      while (game.player.processEachHit(coordinates)) {
        if (game.cpu.areAllShipsSunk()) {
          game.setState(State.PLAYER_WIN);
          break;
        } else {
          coordinates = game.grabUserCoordinates();
        }
        // all in loop that'll iterate as long as not in terminal state
      }
      if (!game.getState().isTerminal()) {
        game.player.addMiss(coordinates);
        game.setState(State.CPU_MOVEMENT);
        coordinates = game.grabRandomCoordinates();
        while (game.cpu.processEachHit(coordinates)) {
          if (game.player.areAllShipsSunk()) {
            game.setState(State.CPU_WIN);
            break;
          } else {
            coordinates = game.grabRandomCoordinates();
          }
        }
        if (!game.getState().isTerminal()) {
          game.cpu.addMiss(coordinates);
        }
          // invoke a method to have the computer shoot
      }

    }

  }


}
