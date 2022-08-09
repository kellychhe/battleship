1. Model
   1. Game (board talk) -Kelly
      1. Static fields 
         1. Create Grid -done
            1. nested Symbol array 10x10
         2. Max Row = 10
         3. Max Col = 10
         4. State field
      2. Grid Interface with two classes that extend it (PlayerGrid & ComputerGrid)
         1. Player Grid houses the methods to set up the player's grid
         2. Computer Grid will house the random CPU set up methods
   2. Symbol Enum-Alexx
      1. X - miss (U+0058)
      2. O - hit (U+004F)
      3. S - sink (U+0053)
   3. Ship Enum-Julian
      1. Carrier - 5
      2. Battleship - 4
      3. Destroyer - 3
      4. Submarine - 3
      5. Patrol Boat - 2
   4. Direction Enum - Alexx
      1. North
      2. South
      3. East
      4. West
   5. State Enum - All
      1. Methods
         1. 
      2. USER MOVE
      3. COMPUTER MOVE
      4. USER WIN
      5. COMPUTER WIN
2. View
3. Controller
   1. 8/9 
      1. read coordinates user enters // compare to Nicks || 
      2. Ships.java placementCheck // JuJu attempt
      3. Ships class for player and CPU extends Ships enum // Alexx
      4. hitCounter(least of worries for now) // TBD

