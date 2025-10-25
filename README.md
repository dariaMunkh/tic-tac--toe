# tic-tac-toe
A command-line Tic-Tac-Toe game where you face a strong AI opponent! Built with Java and powered by the Minimax algorithm, this project demonstrates how computers can play games by thinking several moves ahead.

## How It's Made:
**Tech used:** Java

This project was built using Java with an object-oriented approach. The core of the game revolves around five main classes that work together:


The TicTacToe class handles all the game board logic - checking wins, losses, draws, and generating all possible next moves. I implemented a deep copy mechanism here so that when the AI explores different move possibilities, it doesn't mess with the actual game state.
The Player abstract class serves as the blueprint for different player types, which allowed me to create both human and AI players that the game can treat the same way. This is where object-oriented design really shines!
The AIPlayer is where the magic happens. I implemented the Minimax algorithm with recursive maxValue() and minValue() methods. The AI literally explores every possible game outcome from any position and chooses the move that guarantees the best result. It simulates the entire game tree - if the AI finds a winning path, it takes it; if all paths lead to a loss, it picks the one that delays defeat the longest; and if a draw is the best outcome, it plays for that.
The UserPlayer class handles human input through the console. It displays all possible moves as numbered options, making it intuitive for players to select their next move without worrying about coordinates.
Finally, the Game class ties everything together with a clean game loop that alternates between players, checks for game-ending conditions, and announces the winner. I made sure to keep the user experience smooth with clear prompts and board visualization after each move.

