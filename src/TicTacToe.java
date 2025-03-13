import java.util.Scanner;

/**
 * A simple Tic-Tac-Toe game implementation in Java.
 */

public class TicTacToe {

	/**
	 * The main method to run the Tic-Tac-Toe game.
	 *
	 * @param args Command line arguments (not used).
	 */

	public static void main(String[] args) {
		// TODO: Initialize the game board and scanner

		Scanner reader = new Scanner(System.in);

		char [][] board = {
				{' ',' ',' '},
				{' ',' ',' '},
				{' ',' ',' '}};

		// TODO: Print the initial game board

		printBoard(board);

		int validMoves = 0;
		boolean gameEnded = false; // flag
		int player = 0; // first player number

		// TODO: Prompt the current player for their move
		// TODO: Update the board with the player's move
		// TODO: Handle invalid move
		// TODO: Check if the game has ended

		while(!gameEnded){
			System.out.println("player " + (player+1) + " enter your row number: ");
			int row = reader.nextInt();
			System.out.println("player " + (player+1) + " enter your column number: ");
			int column = reader.nextInt();

			if(isValid(row,column) && board[row-1][column-1] == ' '){

				board[row-1][column-1] = player == 0 ? 'X' : 'O';
				printBoard(board);
				player = ++player % 2;
				validMoves++;
			}else{
				System.out.println("please provide another coordinates!");
			}
			gameEnded = validMoves == 9 || checkboard(board,row = row-1,column = column-1);
		}
	}



	/**
	 * Checks if the current player has won the game.
	 *
	 * @param board The game board.
	 * @param row The row of the last move.
	 * @param column The column of the last move.
	 * @return True if the current player has won, false otherwise.
	 */

	public static boolean checkboard(char[][] board, int row, int column) {
		// TODO: Implement the logic to check if the current player has won

		char symbol = board[row][column];
		boolean win = true; // flag

		for (int i = 0; i < 3; i++) {
			if (board[row][i] != symbol) {
				win = false;
				break;
			}
		}
		if (win) {
			return true;

		}
		for (int i = 0; i < 3; i++) {
			if (board[i][column] != symbol) {
				win = false;
				break;
			}

		}
		if (win) {
			return true;

		}
		if(row == column){
			win = true;
			for (int i = 0; i < 3; i++) {
				if(board[i][i] != symbol){
					win = false;
					break;

				}

			}

		}
		if(row + column == 2){
			win = true;
			for (int i = 0; i < 3; i++) {
				if(board[2-i][i] != symbol){
					win = false;
					break;

				}
			}
		}
		if (win) {
			return true;

		}

		return false;
    }



	/**
	 * Prints the current state of the game board.
	 *
	 * @param board The game board.
	 */

	public static void printBoard(char[][] board) {
		// TODO: Implement the logic to print the game board

		System.out.println("		1		2		3");
		System.out.println("	------------------------");

		for(int row = 0; row < 3; row++) {
			System.out.print(row+1 + " ");
			for (int column = 0; column < 3; column++) {
				System.out.print("	|");
				System.out.print(" " +
						board[row][column] + " ");
				if (column == 2){
					System.out.print("	|");
				}
			}
			System.out.println();
			System.out.println("	------------------------");
		}
	}



	/**
	 * Validates if the given row and column are within the valid range.
	 *
	 * @param row The row number.
	 * @param column The column number.
	 * @return True if the row and column are valid, false otherwise.
	 */

	public static boolean isValid(int row, int column) {
		// TODO: Implement the logic to validate the row and column

		if(row < 1 || row > 3){
			return false;
		}if(column < 1 || column > 3){
			return false;
		}
		return true;
	}
}