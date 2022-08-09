package com.ahjrkc.battleship.controller;

import com.ahjrkc.battleship.model.Ships.ShipType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Mediator {

  public int rowCoordinate;
  public int colCoordinate;

  private ShipType[] playerShips = new ShipType[]
      {ShipType.PLAYER_CARRIER, ShipType.PLAYER_BATTLESHIP, ShipType.PLAYER_DESTROYER, ShipType.PLAYER_SUBMARINE, ShipType.PLAYER_PATROL_BOAT};

  public void playerSetShips() {
    for (ShipType ship : playerShips) {
      try (
          Reader reader = new InputStreamReader(System.in);
          BufferedReader buffer = new BufferedReader(reader);
          ) {
        System.out.printf("It is time to pick the coordinates to set your ships! Let's place your %s.", ship);
        rowCoordinate = Integer.parseInt(buffer.readLine());
        colCoordinate = Integer.parseInt(buffer.readLine());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  // Write a method that prompts the reader for the coordinates to place their ships
      // incorporate loop to ask for each ship
      // return the coordinates for each ship to the PlayerShips for ship placement (addPosition method)
}
