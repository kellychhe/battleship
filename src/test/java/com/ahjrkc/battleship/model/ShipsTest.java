package com.ahjrkc.battleship.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class ShipsTest {

  @Test
  void testProcessEachHit() {
    ArrayList<int[]> placement = new ArrayList<>();
    placement.add(new int[]{1, 1});
    placement.add(new int[]{1, 2});
    Ships ship = new Ships(ShipType.PATROL_BOAT, placement);
    assertTrue(ship.processEachHit(1, 1));
    assertTrue(ship.processEachHit(1, 2));
    assertFalse(ship.processEachHit(1, 3));
  }


  @Test
  void testIsSunk() {
    ArrayList<int[]> placement = new ArrayList<>();
    placement.add(new int[]{1, 1});
    placement.add(new int[]{1, 2});
    Ships ship = new Ships(ShipType.PATROL_BOAT, placement);
    assertFalse(ship.isSunk());
    ship.processEachHit(1,1);
    assertFalse(ship.isSunk());
    ship.processEachHit(1,4);
    ship.processEachHit(1,2);
    assertTrue(ship.isSunk());
  }
  // review individual test result with Nick
}