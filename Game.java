
import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);

  System.out.println("Welcome to Tic-Tac-Toe!");
  System.out.println("========================\n");

  // Get player name
  System.out.print("Enter your name: ");
  String playerName = scanner.nextLine();

  // Create players
  UserPlayer human = new UserPlayer(scanner, playerName);
  AIPlayer ai = new AIPlayer("Computer", human);

  // Create game board with human as X, AI as O
  TicTacToe game = new TicTacToe(human, ai);

  System.out.println("\nYou are X, Computer is O");
  System.out.println("Let's play!\n");

  // Game loop
  Player currentPlayer = human; // Human goes first

  while (!game.checkWin(human) && !game.checkWin(ai) && !game.checkDraw()) {
    System.out.println(currentPlayer + "'s turn:");
    game = currentPlayer.chooseMove(game);

    // Switch players
    if (currentPlayer == human) {
      currentPlayer = ai;
    } 
		else {
      currentPlayer = human;
    }

    System.out.println();
  }

  // Display final board
  System.out.println("Final board:");
  System.out.println(game);

  // Announce result
  if (game.checkWin(human)) {
    System.out.println("Congratulations " + playerName + "! You won!");
  } 
	else if (game.checkWin(ai)) {
    System.out.println("Computer wins! Better luck next time.");
  } 
	else {
  	System.out.println("It's a draw! Good game.");
  }

  scanner.close();
  }
}
