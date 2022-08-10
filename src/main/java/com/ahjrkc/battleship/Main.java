package com.ahjrkc.battleship;

import com.ahjrkc.battleship.controller.Game;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    // testing methods from Game Class
    Game game = new Game();
    game.greetPlayer();
    game.grabUserCoordinates();
  }


}
