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

Tuesday August 2022, 2022:
- Mentor Meeting Focuses:
  - Want to: 
    - Work on Game method (controller package)
      - create instance of board, get info from player to tell the board where to place the ship 
        - Constructor, Methods (What should we consider and what should they do)
        - When to switch States
      - Game will ask player for a set of coordinates for target, human player (bufferreader w/ read line with parse)
      - google : getting input from keyboard in Java
      - Keep using readline until you get two numbers separated by a comma
      - TEST get coordinates
    - Main Class => Get user interaction
- Post Mentor Meeting Next Steps
  - Board => Keeps track of ship locations, be aware of any conflicts, check each ship to see if it's been hit
  - Misses can stay in board (fire elmo, markertype lives!) 
  - Board Methods: placeShip(ShipType, placement array) => construct new ship and add to array of ships for that player
    - allShipsSunk method => review all ships to see if they're sunk (end game)
    - board really only needs to keep track of misses 
    - board test class 

