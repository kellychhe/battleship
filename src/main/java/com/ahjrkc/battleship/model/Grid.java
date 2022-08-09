package com.ahjrkc.battleship.model;

import static com.ahjrkc.battleship.model.Game.*;

import java.security.SecureRandom;
import java.util.Random;

public interface Grid {

  Ships ships[] = null;
  ShipDirection shipDirection[] = ShipDirection.values();
  Random rng = new SecureRandom();

  static Ships[][] createShipsGrid() {
    return new Ships[NUM_OF_ROWS][NUM_OF_COLS];
  }

  static MarkerType[][] createMarkerGrid() {
    return new MarkerType[NUM_OF_ROWS][NUM_OF_COLS];
  }


  Ships[][] setShipsGrid();

  int[] shipIndex(Ships ship);
}
