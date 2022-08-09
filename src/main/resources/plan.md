1. Model
   1. Game (board talk) -Kelly 
      1. NO BOARD 
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
         1. Can't extend an enum, create ships class with default methods (empty for now) and unique fields
      4. hitCounter(least of worries for now) // TBD
4. Presentation
   1. Blue Jawn with a Sailor Hat

- Mentor Meeting Focuses:
  - Want to: 
    - Work on Game method
      - Constructor, Methods (What should we consider and what should they do)
      - When to switch States
    - Main Class => Get user interaction

