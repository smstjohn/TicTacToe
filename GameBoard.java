import java.util.Arrays;
import java.util.Scanner;

public class GameBoard{
   private char[][] gameBoard;
   private boolean gameOnGoing = true;
   
   //constructor for Gameboard class
   public GameBoard() {
      gameBoard = new char[3][3];
      
      for (int row=0; row < gameBoard.length; row++) {
         Arrays.fill(gameBoard[row], ' ');
      }
   }
   
   public void displayBoard() {
      for (int row=0; row < gameBoard.length; row++) {
         for (int col=0; col < gameBoard[0].length; col++) {
            System.out.print("\t" + gameBoard[row][col]);
            if (col == 0 || col == 1)
               System.out.print("|");
         }
         if (row == 0 || row == 1) 
         System.out.print("\n------------\n");
      }
      System.out.println();
   }
   //checks if there is space on the game board and return true if active
   public boolean gameActive() {
      return gameOnGoing;
   }
   //asks the user to pick a row and column, validate the inputs and calls makeMove
   public void askPlayer(char player) {
      Scanner keyboard = new Scanner(System.in);
      int row, col;
      
      do {
         System.out.print("Player " + player + " Please enter a row (1-3): ");
         row = keyboard.nextInt();
         
         System.out.print("Player " + player + " Please enter a column (1-3): ");
         col = keyboard.nextInt();
      }
         while (notValid(row, col));
         
         makeMove(player, row-1, col-1);
   }
   //this method will check for winner
   public boolean checkForWinner() {
      //loop through each row and check for winner
      for (int row = 0; row < gameBoard.length; row++) {
         if (gameBoard[row][0] == gameBoard[row][1] && gameBoard[row][1] == gameBoard[row][2] && gameBoard[row][0] != ' ') {
            System.out.print("The winner is " + gameBoard[row][0] + "!");
            gameOnGoing = false;
         }
      }
      //loop through each col and check for winner
      for (int col = 0; col < gameBoard.length; col++) {
         if (gameBoard[0][col] == gameBoard[1][col] && gameBoard[1][col] == gameBoard[2][col] && gameBoard[0][col] != ' '){
            System.out.print("The winner is " + gameBoard[0][col] + "!");
            gameOnGoing = false;
         }
      }
      //loop through check diagonals for winner
      if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[0][0] != ' '){ 
            System.out.print("The winner is " + gameBoard[0][0] + "!");
            gameOnGoing = false;
         }
      if (gameBoard[2][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[0][2] && gameBoard[0][2] != ' '){ 
            System.out.print("The winner is " + gameBoard[2][0] + "!");
            gameOnGoing = false;
         }
      return false;
   }
   
   
   //validates if the rows and columns are between 1-3 and if position is currently empty
   public boolean notValid (int row, int col) {
      if (row > 3 || row < 1 || col > 3 || col < 1 || !isEmpty(row, col))
         return true;
      else
         return false;
   }
   
   //method to check if space is empty
   public boolean isEmpty(int row, int col) {
      if (gameBoard[row-1][col-1] == ' ')
         return true;
      else {
         System.out.println("That position is already taken, please select another position.\n");
         return false;
      } 
      
   }
   
   //validates if a player's move is allowed and returns true
   public boolean makeMove(char player, int row, int col) {
      
      if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
         if(gameBoard[row][col] != ' ')
            return false;
         else {
            gameBoard[row][col] = player;
            return true;
         }
      }
      else 
         return false;
   }
}