package com.ahjrkc.battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
  // edited to create, will move
  public static void main(String[] args) {
    try (
        Reader reader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(reader)
    ) {
      System.out.println("What is your name, sailor?");
      String playerName = buffer.readLine();
      System.out.printf("Welcome to Battleship, %s! ", playerName);
      System.out.println("Now it is time to place your ships. Please pick a number between 0-9 for your ship placements. What are your coordinates?");
      int xCoordinate = Integer.parseInt(buffer.readLine());
      int yCoordinate = Integer.parseInt(buffer.readLine());
      System.out.printf("Your coordinates have been recorded as %1$d & %2$d!", xCoordinate, yCoordinate);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


}
