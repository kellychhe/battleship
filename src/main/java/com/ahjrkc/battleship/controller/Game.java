package com.ahjrkc.battleship.controller;

import com.ahjrkc.battleship.model.Board;
import com.ahjrkc.battleship.model.ShipDirection;
import com.ahjrkc.battleship.model.ShipType;
import com.ahjrkc.battleship.model.State;
import com.ahjrkc.battleship.model.exceptions.IllegalMoveException;
import com.ahjrkc.battleship.view.GridView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * <p>The <strong>Game Class</strong> serves as </p>
 */
public class Game {

  public static final int NUM_OF_ROWS = 10;
  public static final int NUM_OF_COLS = 10;
  public static final String PLAYER_WON_MESSAGE = "YOU WON! YOU ARE THE CAPTAIN OF THE SEA!";
  public static final String PLAYER_LOSS_MESSAGE = "YA LOSS, SCALLYWAG. CPU RULES AGAIN.";
  public static final String PLAYER_HIT = "One of your fleet members has been shot!";
  public static final String COMPUTER_HIT = "You hit a CPU ship, good work!";
  public static final String PLAYER_MISS = "Ya missed, der matey.";
  public static final String CPU_MISS = "CPU did not hit anything.";
  public static final String CPU_SUNK_SHIP = "You sunk a CPU's %1$s!%n";
  public static final String PLAYER_SUNK_SHIP = "Your %1$s has been sunk!%n";
  private static final Pattern INPUT_SPLITTER = Pattern.compile("\\D+");
  public Random rng = new SecureRandom();
  private State state;
  public String playerName;
  private int sunkCount = 0;
  public int[] shot;
  public Board player = new Board();
  public Board cpu = new Board();

  public ShipType[] fleet = new ShipType[]{
      ShipType.CARRIER,
      ShipType.BATTLESHIP,
      ShipType.DESTROYER,
      ShipType.SUBMARINE,
      ShipType.PATROL_BOAT
  };

  public ShipDirection[] directions = new ShipDirection[]{
      ShipDirection.NORTH,
      ShipDirection.SOUTH,
      ShipDirection.EAST,
      ShipDirection.WEST
  };


  public Game(State state) {
    setState(state);
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  public void greetPlayer() throws IOException {
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Ahoy there Matey! What is your name?");
    playerName = buffer.readLine().trim();
    System.out.printf("Welcome to Battleship, %s!%n", playerName);}

  public void setShips(Board board) throws IOException {

    for (ShipType ship : fleet) {
      boolean placementSuccess = false;

      if (board.equals(player)) {
        System.out.printf("Okay %1$s, it's time to place your %2$s on the board!%n",
              playerName, ship.getName());
      }

      while (!placementSuccess) {
        int[] coordinates = board.equals(player) ? grabUserCoordinates() : grabRandomCoordinates();
        List<ShipDirection> shuffleDirections = Arrays.asList(directions);
        Collections.shuffle(shuffleDirections);
        for (ShipDirection direction : shuffleDirections) {
          ArrayList<int[]> placement = createPlacement(ship, coordinates, direction);
          if (!board.isConflict(placement)){
            board.placeShip(ship, placement);
            placementSuccess = true;
            if (board.equals(player)) {
              System.out.printf("%1$s has been placed.%n", ship.getName());
              printGrid(board);
              break;
            }
          }
        }
        if (!placementSuccess && board.equals(player)) {
          System.out.printf("Sorry %s, that is not a valid place for your ship :( %n", playerName);
        }
      }
    }
  }

  public ArrayList<int[]> createPlacement(ShipType ship, int[] coordinates,
      ShipDirection direction) {
    ArrayList<int[]> placement = new ArrayList<>();
    int row = coordinates[0];
    int col = coordinates[1];
    switch (direction) {
      case NORTH:
        for (int i = 0; i < ship.getSpacesFilled() - 1; i++) {
          placement.add(new int[]{row - i, col});
        }
        break;
      case SOUTH:
        for (int i = 0; i < ship.getSpacesFilled(); i++) {
          placement.add(new int[]{row + i, col});
        }
        break;
      case WEST:
        for (int i = 0; i < ship.getSpacesFilled(); i++) {
          placement.add(new int[]{row, col + i});
        }
        break;
      case EAST:
        for (int i = 0; i < ship.getSpacesFilled(); i++) {
          placement.add(new int[]{row, col - i});
        }
        break;
    }
    return placement;
  }

  public int[] grabUserCoordinates() throws IOException {
    Reader reader = new InputStreamReader(System.in);
    BufferedReader buffer = new BufferedReader(reader);
    do {
      System.out.println();
      System.out.printf("Aye aye %s, Please enter your coordinates.%n", playerName);
      System.out.println();
      System.out.println("Coordinates must be two numbers between 0-9 separated by a comma.");
      String coordinates = buffer.readLine().trim();
      try {
        shot = INPUT_SPLITTER
            .splitAsStream(coordinates)
            .map(String::trim)
            .filter((s) -> !s.isEmpty())
            .mapToInt(Integer::parseInt)
            .filter((value) -> value >= 0 && value < NUM_OF_ROWS)
            .toArray();
      } catch (IllegalArgumentException e) {
        //ignore this exception
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    } while (shot.length != 2 || player.isRepeatShot(shot));

    return shot;
  }

  public int[] grabRandomCoordinates() {
    int row = rng.nextInt(NUM_OF_ROWS);
    int col = rng.nextInt(NUM_OF_COLS);

    int[] shot = new int[]{row, col};
    if (cpu.isRepeatShot(shot)) {
      grabRandomCoordinates();
    }
    if (state != State.PLACEMENT) {
      System.out.printf("Computer shot a cannonball at row %1$d and col %2$d!%n", shot[0], shot[1]);
    }
    return shot;
  }

  public void printGrid(Board board) {
    System.out.println(board.equals(player) ? "This is your map." : "This is the computer map.");
    String[] fullGrid = new String[10];
    for (int i = 0; i < 10; i++) {
      GridView row = new GridView(i);
      if(board.equals(player)){
        fullGrid[i] = row.addPlacement(board.getAllShipPlacements(),board.getMisses(), board.getAllHits(),
            board.getCoordinatesOfSunk());
      } else {
        fullGrid[i] = row.addMissHitSunk(board.getMisses(), board.getAllHits(),
            board.getCoordinatesOfSunk());
      }
      System.out.println(fullGrid[i]);
    }
  }

  public void missAnnouncement(Board board) {
    System.out.println(board.equals(player) ? PLAYER_MISS : CPU_MISS);
  }

  public void sinkAnnouncement(Board board) {
    int length = board.isSunk().size();
    if(sunkCount != length ){
      sunkCount ++;
      System.out.printf(board.equals(player) ? PLAYER_SUNK_SHIP : CPU_SUNK_SHIP, board.isSunk().get(length - 1).getName());
    }
  }

  public void hitAnnouncement(Board board) {
    System.out.println(board.equals(player) ? PLAYER_HIT : COMPUTER_HIT);
    sinkAnnouncement(board);
  }

  public void winnerAnnouncement(Board board) {
    System.out.println(board.equals(player) ? PLAYER_WON_MESSAGE : PLAYER_LOSS_MESSAGE);
  }

}
