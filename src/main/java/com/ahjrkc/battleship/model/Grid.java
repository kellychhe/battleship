package com.ahjrkc.battleship.model;

import static com.ahjrkc.battleship.model.Game.*;

public interface Grid {

  MarkerType[][] grid = new MarkerType[NUM_OF_ROWS][NUM_OF_COLS];

  void setGrid();

}
