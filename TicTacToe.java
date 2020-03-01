import java.util.Scanner;

public class TicTacToe {
   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      char answer = 'Y';
      String response;
      GameBoard myGame = new GameBoard();
      int counter = 1;
      
      System.out.println("Let's play Tic Tac Toe!");
      
      while (answer == 'Y') {
         while (myGame.gameActive() ) {
            if (counter % 2 == 0)
               myGame.askPlayer('O');
            else 
               myGame.askPlayer('X');
            counter++;
            
            System.out.println ("\n");
            myGame.displayBoard();
            System.out.println();
            myGame.checkForWinner();
            
         }
        System.out.println("\nGoodbye!");
      }
   }
}