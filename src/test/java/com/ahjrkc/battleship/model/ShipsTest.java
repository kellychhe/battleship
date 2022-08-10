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
    assertEquals(ship.processEachHit(1,1), true);
    assertEquals(ship.processEachHit(1,2), true);
    assertEquals(ship.processEachHit(1,3), false);
  }


  @Test
  void testIsSunk() {
    ArrayList<int[]> placement = new ArrayList<>();
    placement.add(new int[]{1, 1});
    placement.add(new int[]{1, 2});
    Ships ship = new Ships(ShipType.PATROL_BOAT, placement);
    assertEquals(ship.isSunk(), false);
    ship.processEachHit(1,1);
    assertEquals(ship.isSunk(), false);
    ship.processEachHit(1,4);
    ship.processEachHit(1,2);
    assertEquals(ship.isSunk(), true);
  }
  // review individual test result with Nick
}