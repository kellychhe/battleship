package com.ahjrkc.battleship.model;

import static com.ahjrkc.battleship.model.Game.NUM_OF_COLS;
import static com.ahjrkc.battleship.model.Game.NUM_OF_ROWS;

import java.util.ArrayList;
import java.util.Collection;

public class ComputerGrid implements Grid {

  Ships[][] shipsGrid;

  @Override
  public Ships[][] setShipsGrid() {
    shipsGrid = Grid.createShipsGrid();
    for (Ships ship : ships) {
      int[] indexes = shipIndex(ship);

    }

    return new Ships[0][];
  }

  @Override
  public int[] shipIndex(Ships ship) {
    int randomRow = Grid.rng.nextInt(NUM_OF_ROWS);
    int randomCol = Grid.rng.nextInt(NUM_OF_COLS);
    ShipDirection direction = shipDirection[Grid.rng.nextInt(shipDirection.length)];
    int spaceFilled = ship.getSpacesFilled();
    for (int i = 0; i < spaceFilled; i++) {
      i *= direction.getSign();
      if (direction == ShipDirection.EAST || direction == ShipDirection.WEST) {
        if (shipsGrid[randomRow][randomCol - i] != null) {
//          return new int[]{randomRow, randomCol};
        }
      } else {
        if (shipsGrid[randomRow - i][randomCol] != null) {
//          return new int[]{randomRow, randomCol};
        }
      }
      i = Math.abs(i);
    }
    return new int[0];
  }


}
