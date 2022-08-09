package com.ahjrkc.battleship.model;

import com.ahjrkc.battleship.model.exceptions.IllegalPlacementException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayerShips implements Ships{


  @Override
  public static List<ShipDirection> availableDirection(int row, int col, ShipType type) {
    List<ShipDirection> validDirections = new ArrayList<>();
    if (isNorthAvailable(row, col, type)){
      validDirections.add(ShipDirection.NORTH);
    } else if (isSouthAvailable(row, col, type)){
      validDirections.add(ShipDirection.SOUTH);
    } else if (isWestAvailable(row, col, type)){
      validDirections.add(ShipDirection.WEST);
    } else if (isEastAvailable(row, col, type)){
      validDirections.add(ShipDirection.EAST);
    } else {
      throw new IllegalPlacementException(State.ILLEGAL_PLACEMENT);
    }
    return validDirections;
  }

  @Override
  public boolean isNorthAvailable(int row, int col, ShipType type) {
    List<int[]> allShipPositions = getAllShipPositions();
    int shipCapacity = type.position.size();
    for (int i = 0; i < shipCapacity; i++) {
      if (col - i < 0) {
        return false;
      }
      int[] currentCoordinates = new int[]{row, col - i};
      for (int[] position : allShipPositions) {
        if (!Arrays.equals(currentCoordinates, position) && position != null) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public boolean isSouthAvailable(int row, int col, ShipType type) {
    List<int[]> allShipPositions = getAllShipPositions();
    int shipCapacity = type.position.size();
    for (int i = 0; i < shipCapacity; i++) {
      if (col + i > 10) {
        return false;
      }
      int[] currentCoordinates = new int[]{row, col + i};
      for (int[] position : allShipPositions) {
        if (!Arrays.equals(currentCoordinates, position) && position != null) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public boolean isWestAvailable(int row, int col, ShipType type) {
    List<int[]> allShipPositions = getAllShipPositions();
    int shipCapacity = type.position.size();
    for (int i = 0; i < shipCapacity; i++) {
      if (row - i < 0) {
        return false;
      }
      int[] currentCoordinates = new int[]{row - i, col};
      for (int[] position : allShipPositions) {
        if (!Arrays.equals(currentCoordinates, position) && position != null) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public boolean isEastAvailable(int row, int col, ShipType type) {
    List<int[]> allShipPositions = getAllShipPositions();
    int shipCapacity = type.position.size();
    for (int i = 0; i < shipCapacity; i++) {
      if (row + i < 0) {
        return false;
      }
      int[] currentCoordinates = new int[]{row + i, col};
      for (int[] position : allShipPositions) {
        if (!Arrays.equals(currentCoordinates, position) && position != null) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public void addPosition(int playerRow, int playerCol, ShipDirection direction) {

  }

  private List<int[]> getAllShipPositions() {
    List<int[]> allShipPositions = Stream
        .of(ShipType.PLAYER_BATTLESHIP.getPosition(), ShipType.PLAYER_SUBMARINE.getPosition(),
            ShipType.PLAYER_CARRIER.getPosition(), ShipType.PLAYER_DESTROYER.getPosition(),
            ShipType.PLAYER_PATROL_BOAT.getPosition())
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
    return allShipPositions;
  }

}
