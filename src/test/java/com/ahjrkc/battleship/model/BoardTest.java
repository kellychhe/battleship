package com.ahjrkc.battleship.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class BoardTest {

  @Test
  void testPlaceShip() {
    ArrayList<int[]> placement = new ArrayList<>();
    placement.add(new int[]{1, 1});
    placement.add(new int[]{1, 2});

    Board board = new Board();
    ShipType type = ShipType.PATROL_BOAT;
    board.placeShip(type, placement);

    ArrayList<Ships> expected = new ArrayList<>();
    expected.add(new Ships(type, placement));
    System.out.println(expected);
    assertEquals(expected.size(), board.ships.size());
  }

  @Test
  void testIsConflict() {
    Board board = new Board();


  }

  @Test
  void testAreAllShipsSunk() {
    Board board = new Board();


  }

  @Test
  void testAddMiss() {
    ArrayList<int[]> expectedMisses = new ArrayList<>();
    expectedMisses.add(new int[]{7,7});

    int[] shot = new int[]{7,7};
    Board board = new Board();
    board.addMiss(shot);

    assertEquals(expectedMisses.size(), board.misses.size());
    for(int i = 0; i < expectedMisses.size(); i++) {
      assertArrayEquals(expectedMisses.get(i), board.misses.get(i));
    }
  }

  @Test
  void testIsRepeatShot() {
    Board board = new Board();
//
//    assertTrue();
//    assertFalse();
  }
}