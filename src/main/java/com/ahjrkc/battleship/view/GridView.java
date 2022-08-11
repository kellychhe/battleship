package com.ahjrkc.battleship.view;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GridView {
  public int rowIndex;
  public char[] markers = new char[10];

  public GridView(int rowIndex) {
    this.rowIndex = rowIndex;
  }

  public String addPlacement(ArrayList<int[]> allShipPlacements,ArrayList<int[]> misses,
      ArrayList<int[]> hits, ArrayList<int[]> sunkCoordinates) {
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
    for (int i = 0; i < markers.length; i++) {
      if (markers[i] == '\u0000') {
        markers[i] = MarkerType.NONE.getSymbol();
      }
    }
    return Stream.of(markers)
        .map(String::new)
        .collect(Collectors.joining()).replaceAll(".", "$0\t");
  }


}
