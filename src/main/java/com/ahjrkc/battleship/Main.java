package com.ahjrkc.battleship;

import com.ahjrkc.battleship.controller.Game;
import com.ahjrkc.battleship.model.State;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    Game game = new Game(State.PLACEMENT);
    if (game.getState() == State.PLACEMENT) {
      game.greetPlayer();
      // game.setShips(game.cpu)
      // game.setShips(game.player);
    }
    game.setState(State.PLAYER_MOVEMENT);
    int[] coordinates = game.grabUserCoordinates();
    if (game.player.processEachHit(coordinates) == false) {
      game.player.addMiss(coordinates);
      game.setState(State.CPU_MOVEMENT);
    } else {

    }

  }


}
