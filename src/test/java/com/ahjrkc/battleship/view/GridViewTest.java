package com.ahjrkc.battleship.view;

import static org.junit.jupiter.api.Assertions.*;

import com.ahjrkc.battleship.model.Board;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GridViewTest {

  @Test
  void createRowString() {
    ArrayList<int[]> allShipPlacements = new ArrayList<>();
    allShipPlacements.add(new int[]{1,1});
    allShipPlacements.add(new int[]{2,1});
    allShipPlacements.add(new int[]{3,1});
    allShipPlacements.add(new int[]{4,1});
    allShipPlacements.add(new int[]{5,1});
    GridView line = new GridView(1);

  }

  @Test
  void displayShipPlacement() {
    ArrayList<int[]> allShipPlacements = new ArrayList<>();
    ArrayList<int[]> misses = new ArrayList<>();
    ArrayList<int[]> hits = new ArrayList<>();
    ArrayList<int[]> sunkCoordinates = new ArrayList<>();

    allShipPlacements.add(new int[]{1, 2});
    allShipPlacements.add(new int[]{1, 1});
    allShipPlacements.add(new int[]{1, 3});
    allShipPlacements.add(new int[]{1, 4});
    allShipPlacements.add(new int[]{1, 5});

    GridView line1 = new GridView(1);

    char[] expectedChars1 = new char[]{'\u0000', '\u2591', '\u2591', '\u2591', '\u2591', '\u2591', '\u0000', '\u0000','\u0000', '\u0000'};
    String actual1 = line1.addPlacement(allShipPlacements,misses, hits, sunkCoordinates);
    String expected1 = Stream.of(expectedChars1)
        .map(String::new)
        .collect(Collectors.joining());
    assertEquals(expected1, actual1);

    allShipPlacements.add(new int[]{2,2});
    allShipPlacements.add(new int[]{1,2});
    allShipPlacements.add(new int[]{3,2});
    allShipPlacements.add(new int[]{4,2});
    allShipPlacements.add(new int[]{5,2});
    GridView line2 = new GridView(2);


    char[] expectedChars2 = new char[]{'\u0000', '\u0000', '\u2591', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000','\u0000', '\u0000'};
    String actual2 = line2.addPlacement(allShipPlacements,misses, hits, sunkCoordinates);
    String expected2 = Stream.of(expectedChars2)
        .map(String::new)
        .collect(Collectors.joining());
    assertEquals(expected2, actual2);


  }
}