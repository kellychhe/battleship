package com.ahjrkc.battleship.view;

import com.ahjrkc.battleship.model.Board;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GridView {
  // pass in board with ships and hits & array of misses
  // 2-d array of chars => use marker type to put chars in grid
  // every invocation, start fresh
  // use 2d array of char, traditional for loop to iterate over array of strings and array of chars

  // construct a string to pass to controller that will display after each shot

  // have methods return strings and print from controller (stringBuilders, etc.)
  // all one string or an array of strings, then iterate by row

  // further suggestion, start with 10 x 10 w/o additional empty spaces
  // each square is 3x3 character display (30 x 30)
  // render with space, character, space for each cell => dont need spacing to get spacing
  public int rowIndex;
  public Board board;
  public char[] markers = new char[10];

  public GridView(int rowIndex) {
    this.rowIndex = rowIndex;
  }

  public String addPlacement(ArrayList<int[]> allShipPlacements,ArrayList<int[]> misses, ArrayList<int[]> hits, ArrayList<int[]> sunkCoordinates) {
    for (int[] allShipPlacement : allShipPlacements) {
      int row = allShipPlacement[0];
      int col = allShipPlacement[1];
      if (row == rowIndex) {
        markers[col] = MarkerType.SHIP.getSymbol();
      }
    }
    return addMissHitSunk(misses, hits, sunkCoordinates);
  }

  public String addMissHitSunk(ArrayList<int[]> misses, ArrayList<int[]> hits,
      ArrayList<int[]> sunkCoordinates) {
    for (int[] miss : misses) {
      int row = miss[0];
      int col = miss[1];
      if (row == rowIndex) {
        markers[col] = MarkerType.MISS.getSymbol();
      }
    }
    for (int[] hit : hits) {
      int row = hit[0];
      int col = hit[1];
      if (row == rowIndex) {
        markers[col] = MarkerType.HIT.getSymbol();
      }
    }
    for (int[] sunkCoordinate : sunkCoordinates) {
      int row = sunkCoordinate[0];
      int col = sunkCoordinate[1];
      if (row == rowIndex) {
        markers[col] = MarkerType.SINK.getSymbol();
      }
    }

    return Stream.of(markers)
        .map(String::new)
        .collect(Collectors.joining());
  }


}
