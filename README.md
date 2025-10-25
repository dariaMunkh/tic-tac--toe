# Tic-Tac-Toe
A command-line Tic-Tac-Toe game where you face a strong AI opponent! Built with Java and powered by the Minimax algorithm, this project demonstrates how computers can play games by thinking several moves ahead.

## How It's Made:
**Tech used:** Java

This project was built using Java with an object-oriented approach. The core of the game revolves around five main classes that work together:


The TicTacToe class handles all the game board logic - checking wins, losses, draws, and generating all possible next moves. I implemented a deep copy mechanism here so that when the AI explores different move possibilities, it doesn't mess with the actual game state.
The Player abstract class serves as the blueprint for different player types, which allowed me to create both human and AI players that the game can treat the same way. This is where object-oriented design really shines!
The AIPlayer is where the magic happens. I implemented the Minimax algorithm with recursive maxValue() and minValue() methods. The AI literally explores every possible game outcome from any position and chooses the move that guarantees the best result. It simulates the entire game tree - if the AI finds a winning path, it takes it; if all paths lead to a loss, it picks the one that delays defeat the longest; and if a draw is the best outcome, it plays for that.
The UserPlayer class handles human input through the console. It displays all possible moves as numbered options, making it intuitive for players to select their next move without worrying about coordinates.
Finally, the Game class ties everything together with a clean game loop that alternates between players, checks for game-ending conditions, and announces the winner. I made sure to keep the user experience smooth with clear prompts and board visualization after each move.

## Lesson's Learned:

This was my first time building game AI, and it taught me a lot about how recursion actually works. At first, the maxValue() and minValue() methods calling each other back and forth was really confusing - it felt like an endless loop! But then I realized it's just the AI thinking ahead: "If I move here, then you'll move there, then I'll move here..." Once I saw it that way, everything made sense.
I also learned you can't just change the game board while the AI is thinking. My first try did that and it broke everything - the AI would mess up the actual game while exploring different moves. The fix was simple: make a copy of the board for each possible move. That way the AI can test out moves without breaking the real game

## Installation and Running

1. Clone this repository
2. Compile all Java files:

javac *.java

3. Run the game:


java Game


## Gameplay

You play as X and always go first


The AI plays as O


Enter the number of your desired move when prompted


Try to achieve a draw - the AI cannot be beaten!
