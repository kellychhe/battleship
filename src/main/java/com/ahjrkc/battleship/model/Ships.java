package com.ahjrkc.battleship.model;

import com.ahjrkc.battleship.model.exceptions.IllegalPlacementException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Ships {

  public Random rng = new SecureRandom();

  public ShipDirection getDirection(ShipType type) {
    int[] randomCoordinates = randomCoordinates();
    List<ShipDirection> directions = availableDirection(randomCoordinates[0],randomCoordinates[1], type);

    int index = rng.nextInt(directions.size());

    return directions.get(index);
  }

  public int[] randomCoordinates() {
    int row = rng.nextInt(10);
    int col = rng.nextInt(10);

    return new int[]{row, col};

  }

  public List<ShipDirection> availableDirection(int row, int col, ShipType type) {
    List<ShipDirection> validDirections = new ArrayList<>();
    if (isNorthAvailable(row, col, type)) {
      validDirections.add(ShipDirection.NORTH);
    } else if (isSouthAvailable(row, col, type)) {
      validDirections.add(ShipDirection.SOUTH);
    } else if (isWestAvailable(row, col, type)) {
      validDirections.add(ShipDirection.WEST);
    } else if (isEastAvailable(row, col, type)) {
      validDirections.add(ShipDirection.EAST);
    } else {
      throw new IllegalPlacementException("Ship can not be placed here, please try again.");
    }
    return validDirections;
  };

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

  public boolean isEastAvailable(int row, int col, ShipType type) {
    List<int[]> allShipPositions = getAllShipPositions();
    int shipCapacity = type.position.size();
    for (int i = 0; i < shipCapacity; i++) {
      if (row + i > 10) {
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

  private List<int[]> getAllShipPositions() {
    List<int[]> allShipPositions = Stream
        .of(ShipType.COMPUTER_BATTLESHIP.getPosition(), ShipType.COMPUTER_SUBMARINE.getPosition(),
            ShipType.COMPUTER_CARRIER.getPosition(), ShipType.COMPUTER_DESTROYER.getPosition(),
            ShipType.COMPUTER_PATROL_BOAT.getPosition())
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
    return allShipPositions;
  }
  void addPosition(int row, int col, ShipDirection direction);

}
