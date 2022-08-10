package com.ahjrkc.battleship.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.regex.Pattern;
/*
public class Mediator {

  // pattern to parse coordinates, use to divide
  private static final Pattern INPUT_SPLITTER = Pattern.compile("\\D+");
  // ask for user name

  // provide updates until game is finished

  // alternates between states

  public void playerSetShips() {
    // open buffered reader outside of loop without try with resources, can quit prematurely
    Reader reader = new InputStreamReader(System.in);
    BufferedReader buffer = new BufferedReader(reader);
    // dont want to do in loop
//      for (ShipType ship : playerShips) {
//        System.out.printf(
//            "It is time to pick the coordinates to set your ships! Let's place your %s.",
//            ship.getName());
//        // gets rid of whitespace, captures user input
//        String input = buffer.readLine().trim();
        // consider extracting a method to use for placement and shooting, put everything in while loop to capture invalid inputs
        int[] userCoordinates = INPUT_SPLITTER
            // stream of strings
            .splitAsStream(input)
            // trim any space off the streams
            .map(String::trim)
            // filter out empty strings
            .filter((s) -> !s.isEmpty())
            // changes to int primitives
            .mapToInt(Integer::parseInt)
            .filter((value) -> value >= 0 && value < 10)
            .limit(2)
            .toArray();
//        rowCoordinate, colCoordinate = Integer.parseInt(buffer.readLine());
//        colCoordinate = Integer.parseInt(buffer.readLine());
    }
  } */
/*
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

  // Write a method that prompts the reader for the coordinates to place their ships
  // incorporate loop to ask for each ship
  // return the coordinates for each ship to the PlayerShips for ship placement (addPosition method)
}
 */