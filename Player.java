public abstract class Player {

  //Defined by sub-classes; allows player to choose move
  public abstract TicTacToe chooseMove(TicTacToe board);

  //Returns a double value that represents how good the given baord is for this player
  public double boardValue(TicTacToe board){
    if(board.checkWin(this)){
      return 1.0;
    }
    else if(board.checkLose(this)){
      return -1.0;
    }
    else{
      return 0.0;
    }
  }  
}
