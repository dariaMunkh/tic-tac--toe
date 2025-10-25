public class AIPlayer extends Player {
  //Private fields
  private String name;
  private Player opponent;

  //Getter for opponent
  public Player getOpponent(){
    return opponent;
  }

  //Setter for opponent
  public void setOpponent(Player opponent){
    this.opponent = opponent;
  }

  @Override
  public String toString(){
    return name + " (AI)";
  }

  //Constructor to initialize fields
  public AIPlayer(String name, Player opponent){
    this.name = name;
    this.opponent = opponent;
  }

  //Returns the minimum value for the board as a double 
  public double minValue(TicTacToe board){
    //AI player has won
    if(board.checkWin(this)){
      return 1.0;
    }
    //AI player has lost 
    if(board.checkLose(this)){
      return -1.0;
    }
    //Game is a draw 
    if(board.checkDraw()){
      return 0.0;
    }
    
    double min = Double.POSITIVE_INFINITY;
    for(TicTacToe move : board.possibleMoves(opponent)){
      //Recursion
      double value = maxValue(move); 
      min = Math.min(min, value);
    }
    return min;
  }

  public double maxValue(TicTacToe board){
    //AI player has won 
    if(board.checkWin(this)){
      return 1.0;
    }
    //AI player has lost 
    if(board.checkLose(this)){
      return -1.0;
    }
    //Game is a draw
    if(board.checkDraw()){
      return 0.0;
    }

    double max = Double.NEGATIVE_INFINITY;
    for(TicTacToe move : board.possibleMoves(this)) {
      //Recursion
      double value = minValue(move);
      max = Math.max(max, value);
    }
    return max;
  }

  @Override
  //Porvides the best move for AI player by analyzing all possible moves recursively.
  //Returns a new board representing the AI's chosen move
  public TicTacToe chooseMove(TicTacToe board){
    TicTacToe[] moves = board.possibleMoves(this);
    TicTacToe bestMove = null;
    double bestValue = Double.NEGATIVE_INFINITY;

    //Evaluate each possible move and select the one with the highest minValue
    for(TicTacToe move : moves){
      double value = minValue(move);
      if(value > bestValue){
        bestValue = value;
        bestMove = move;
      }
    }
    return bestMove;
  }
  
}
