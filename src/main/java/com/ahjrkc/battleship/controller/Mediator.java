package com.ahjrkc.battleship.controller;

import com.ahjrkc.battleship.model.Ships.ShipType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.regex.Pattern;

public class Mediator {

  // pattern to parse coordinates, use to divide
  private static final Pattern INPUT_SPLITTER = Pattern.compile("\\D+");
  // ask for user name

  // provide updates until game is finished

  // alternates between states

  public int rowCoordinate;
  public int colCoordinate;

  private ShipType[] playerShips = new ShipType[]
      {ShipType.PLAYER_CARRIER, ShipType.PLAYER_BATTLESHIP, ShipType.PLAYER_DESTROYER, ShipType.PLAYER_SUBMARINE, ShipType.PLAYER_PATROL_BOAT};

  public void playerSetShips() {
    // open buffered reader outside of loop without try with resources, can quit prematurely
    for (ShipType ship : playerShips) {
      // dont want to do in loop
      try (
          Reader reader = new InputStreamReader(System.in);
          BufferedReader buffer = new BufferedReader(reader);
          ) {
        System.out.printf("It is time to pick the coordinates to set your ships! Let's place your %s.", ship.getName());
        // gets rid of whitespace, captures user input
        String input = buffer.readLine().trim();
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
        if (PlayerShips.availableDirection(rowCoordinate, colCoordinate, ship).size() == 0) {

        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  // Write a method that prompts the reader for the coordinates to place their ships
      // incorporate loop to ask for each ship
      // return the coordinates for each ship to the PlayerShips for ship placement (addPosition method)
}
