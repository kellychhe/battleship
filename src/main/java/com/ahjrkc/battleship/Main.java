package com.ahjrkc.battleship;

import com.ahjrkc.battleship.model.PlayerShips;
import com.ahjrkc.battleship.model.Ships.ShipType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

  public static void main(String[] args) {
    int rowCoordinate;
    int colCoordinate;

    ShipType[] playerShips = new ShipType[]
        {ShipType.PLAYER_CARRIER, ShipType.PLAYER_BATTLESHIP, ShipType.PLAYER_DESTROYER, ShipType.PLAYER_SUBMARINE, ShipType.PLAYER_PATROL_BOAT};

    for (ShipType ship : playerShips) {
      try (
          Reader reader = new InputStreamReader(System.in);
          BufferedReader buffer = new BufferedReader(reader);
      ) {
        System.out.printf("It is time to pick the coordinates to set your ships! Let's place your %s.", ship.getName());
        rowCoordinate = Integer.parseInt(buffer.readLine());
        colCoordinate = Integer.parseInt(buffer.readLine());
        // nonstatic method needs to be invoked in a non-static context, needs an instance.
        if (PlayerShips.availableDirection(rowCoordinate, colCoordinate, ship).size() == 0) {

        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }


}
