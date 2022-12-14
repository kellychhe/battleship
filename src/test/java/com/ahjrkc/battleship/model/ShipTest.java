package com.ahjrkc.battleship.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class ShipTest {

  @Test
  void testProcessEachHit() {
    ArrayList<int[]> placement = new ArrayList<>();
    placement.add(new int[]{1, 1});
    placement.add(new int[]{1, 2});
    Ship ship = new Ship(ShipType.PATROL_BOAT, placement);
    assertTrue(ship.processEachHit(new int[]{1, 1}));
    assertTrue(ship.processEachHit(new int[]{1, 2}));
    assertFalse(ship.processEachHit(new int[]{1, 3}));
  }

  @Test
  void testIsSunk() {
    ArrayList<int[]> placement = new ArrayList<>();
    placement.add(new int[]{1, 1});
    placement.add(new int[]{1, 2});
    Ship ship = new Ship(ShipType.PATROL_BOAT, placement);
    assertFalse(ship.isSunk());
    ship.processEachHit(new int[]{1,1});
    assertFalse(ship.isSunk());
    ship.processEachHit(new int[]{1, 4});
    ship.processEachHit(new int[]{1, 2});
    assertTrue(ship.isSunk());
  }

}