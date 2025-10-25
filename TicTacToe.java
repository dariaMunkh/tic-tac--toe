import java.util.ArrayList;

public class TicTacToe {
  //Private fields
  private char[][] board;
  private Player x;
  private Player o;

  //Getter for board
  public char[][] getBoard(){
    return board;
  }

  //Setter for board 
  public void setBoard(char[][] board){
    this.board = board;
  }

  //Getter for player x 
  public Player getX(){
    return x;
  }

  //Setter for player x
  public void setX(Player x){
    this.x = x;
  }

  //Getter for player o 
  public Player getO(){
    return o;
  }

  //Setter for player o
  public void setO(Player o){
    this.o = o;
  }

  //Constructor for the class to initialize each field
  public TicTacToe(Player x, Player o){
    this.x = x;
    this.o = o;
    this.board = new char[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        board[i][j] = '_';
      }
    }
  }

  //Count the amount of blank spaces on the board
  public int countBlanks() {
    int count = 0;
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[i].length; j++) {
          if(board[i][j] == '_') {
              count++;
          }
      }
    }
    return count;
  }

  //Identify player as X player or O player
  public char markerForPlayer(Player player){
    if(player.equals(x)){
      return 'X';
    }
    else{
      return 'O';
    }
  }

  //Figure out a possible winner based on how the marks are drawn
  public boolean checkWin(Player player){
    char mark = markerForPlayer(player);

    for(int i = 0; i < 3; i++){
      //Check for horizontal
      if(board[i][0] == mark && board[i][1] == mark && board[i][2] == mark){
        return true;
      }
      //Check for vertical
      else if(board[0][i] == mark && board[1][i] == mark && board[2][i] == mark){
        return true;
      }
      //Check for diagonal
      else if(board[0][0] == mark && board[1][1] == mark && board[2][2] == mark){
        return true;
      }
      //Cheeck for the other diagonal
      else if(board[0][2] == mark && board[1][1] == mark && board[2][0] == mark){
        return true;
      }
    }
    return false;
  }

  //Figure out a possible loser 
  public boolean checkLose(Player player){
    if(player.equals(x)){
      return checkWin(o);
    }
    else{
      return checkWin(x);
    }
  }

  //It is a draw if no blank spaces and no winner
  public boolean checkDraw(){
    return (countBlanks() == 0 && !checkWin(x) && !checkWin(o));
  }

  @Override
  public String toString(){
    String result = "";
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[i].length; j++){
        result += board[i][j];
      }
      result += "\n";
    }
    return result;
  }

  //Represents the possible next moves for the given player
  public TicTacToe[] possibleMoves(Player player){
    ArrayList<TicTacToe> moves = new ArrayList<>();
    char mark = markerForPlayer(player);

    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[i].length; j++) {
        //Check for blank space
        if(board[i][j] == '_') { 
        //Create a new TicTacToe instance and copy the current board's state
          TicTacToe newBoard = new TicTacToe(this.x, this.o);
          copyBoard(this.board, newBoard.board);
          newBoard.board[i][j] = mark;
          moves.add(newBoard);
        }
      }
    }
    return moves.toArray(new TicTacToe[0]);
  }

  //Method used to copy the board
  private void copyBoard(char[][] given, char[][] target){
    for(int i = 0; i < 3; i++){
      System.arraycopy(given[i], 0, target[i], 0, 3);
    }
  }
}
