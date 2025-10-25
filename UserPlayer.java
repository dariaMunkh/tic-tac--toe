import java.util.Scanner;

public class UserPlayer extends Player{
  //Private fields
  private String name;
  private Scanner input;

  //Constructor to initialize fields
  public UserPlayer(Scanner input, String name){
    this.input = input;
    this.name = name;    
  }

  @Override
  public String toString(){
    return name;
  }

  @Override
  //Make sure that the user has options to choose from possible moves
  //Return the move that the user chooses
  public TicTacToe chooseMove(TicTacToe board){
    System.out.println("Current board: ");
    System.out.println(board);
    
    TicTacToe[] possible = board.possibleMoves(this);
    System.out.println("Possible moves: ");

    for(int i = 0; i < possible.length; i++){
      System.out.println("Option " + i + ":");
      System.out.println(possible[i]);
    }

    System.out.print("Enter the number for your possible option: ");
    int choice = input.nextInt();
    return possible[choice];
  }
}
