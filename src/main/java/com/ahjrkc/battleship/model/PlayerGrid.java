package com.ahjrkc.battleship.model;



public class PlayerGrid implements Grid{

  Ships[][] shipsGrid;
  @Override
  public Ships[][] setShipsGrid() {
    return new Ships[0][];
  }

  @Override
  public int[] shipIndex(Ships ship) {
    return new int[0];
  }

}
