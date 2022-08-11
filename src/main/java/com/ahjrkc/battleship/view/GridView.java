package com.ahjrkc.battleship.view;

import com.ahjrkc.battleship.controller.Game;
import com.ahjrkc.battleship.model.Board;
import java.lang.reflect.Array;
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

  public GridView(int rowIndex, Board board) {
    this.rowIndex = rowIndex;
    this.board = board;
  }

  public String createRowString(Board board,ArrayList<int[]> misses, ArrayList<int[]> hits, ArrayList<int[]> sunkCoordinates) {
    for (int i = 0; i < misses.size(); i++) {
      if (misses.get(i)[0] == rowIndex) {
        markers[i] = MarkerType.MISS.getSymbol();
      }
    }
    for (int i = 0; i < hits.size(); i++) {
      if (hits.get(i)[0] == rowIndex) {
        markers[i] = MarkerType.HIT.getSymbol();
      }
    }
    for (int i = 0; i < sunkCoordinates.size(); i++) {
      if (sunkCoordinates.get(i)[0] == rowIndex) {
        markers[i] = MarkerType.SINK.getSymbol();
      }
    }
    for (char marker : markers){
      if ((int) marker == 0) {
        marker = MarkerType.NONE.getSymbol();
      }
    }
    return Stream.of(markers)
        .map(String::new)
        .collect(Collectors.joining());
  }

  // when invoking the following method in controller, make sure to do this one first
  private void displayShipPlacement(ArrayList<int[]> allShipPlacements) {
    for (int i = 0; i < allShipPlacements.size(); i++) {
      if (allShipPlacements.get(i)[0] == rowIndex) {
        markers[i] = MarkerType.SHIP.getSymbol();
      }
    }
  }

}
