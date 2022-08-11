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
      System.out.println("Time to take your shot!");
      int[] coordinates = game.grabUserCoordinates();
      while (game.cpu.processEachHit(coordinates)) {
        if (game.cpu.areAllShipsSunk()) {
          game.winnerAnnouncement(game.player);
          game.setState(State.PLAYER_WIN);
        } else {
//          game.printGrid(game.player);
          game.printGrid(game.cpu);
          game.hitAnnouncement(game.cpu);
          coordinates = game.grabUserCoordinates();
        }
        // all in loop that'll iterate as long as not in terminal state
      }
      if (!game.getState().isTerminal()) {
        game.cpu.addMiss(coordinates);
//        game.printGrid(game.player);
        game.printGrid(game.cpu);
        game.missAnnouncement(game.player);
        game.setState(State.CPU_MOVEMENT);
        coordinates = game.grabRandomCoordinates();

        while (game.player.processEachHit(coordinates)) {
          if (game.player.areAllShipsSunk()) {
            game.printGrid(game.player);
            game.printGrid(game.cpu);
            game.winnerAnnouncement(game.cpu);
            game.setState(State.CPU_WIN);
            break;
          } else {
            game.printGrid(game.player);
//            game.printGrid(game.cpu);
            game.hitAnnouncement(game.player);
            coordinates = game.grabRandomCoordinates();
          }
        }
        if (!game.getState().isTerminal()) {
          game.player.addMiss(coordinates);
          game.printGrid(game.player);
//          game.printGrid(game.cpu);
          game.missAnnouncement(game.cpu);
        }
          // invoke a method to have the computer shoot
      }

    }

  }


}
