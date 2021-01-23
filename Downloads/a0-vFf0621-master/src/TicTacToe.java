/**
 * A TicTacToe class for a text-based, basic two player tic-tac-toe game.
 */
public class TicTacToe {

	private int[][] board; // 2d array representing the tic-tac-toe board
		
	// integers to represent each space on the board
	private static final int EMPTY = 0;
	private static final int CROSS = 1;
	private static final int CIRCLE = -1;

	// set game to "playing" status
	private int winStatus = 0; // status 0 = playing, 1 = won, 2 = draw
	
	/**
	 * Construct a TicTacToe game with an empty board.
	 */
	public TicTacToe() {
		
		this.board = new int[3][3];
		
		// go through each row of the board
		for (int row = 0; row < 3; row++) {
			
			// go through each column of the board
			for (int col = 0; col < 3; col++) {
				
				// set to empty
				this.board[row][col] = EMPTY;
				
			}
			
		}
	}

	/**
	 * Construct a TicTacToe game with the given array as the board.
	 * 
	 * Precondition: The game board is incomplete (not a win or draw)
	 * 
	 * @param board	 a 2d array of integers representing an incomplete board
	 */
	public TicTacToe(int[][] board) {
		
		this.board = board;

	}
	
	/**
	 * Set the space at the given row and column the given mark,
	 * if the space is within the board and not already occupied.
	 * Return false if the board is unchanged.
	 * 
	 * @param mark	an integer representing the mark to be placed on the board
	 * @param row	an integer representing the affected row 
	 * @param col	an integer representing the affected column
	 * @return  true if the board was changed, false otherwise
	 */
	public boolean setMark(int mark, int row, int col) {
		
		if ((0 <= row && row < 3) &&
			(0 <= col && col < 3) &&
			(this.board[row][col] == EMPTY)) {
			
			this.board[row][col] = mark;
			return true;

		} else {
			
			return false;
		}
		
	}
	
	/**
	 * Get the mark at the given row and column.
	 * 
	 * @param row	an integer representing the desired row 
	 * @param col	an integer representing the desire column
	 * @return the mark at the given row and column
	 */
	public int getMark(int row, int col) {
		return this.board[row][col];
	}
	
	/**
	 * Get the current game status.
	 * 
	 * @return 0 if the game is being played, 1 if someone won, 2 if it's a draw
	 */
	public int getGameStatus() {
		return this.winStatus;
	}
	
	/**
	 * Return true iff the board is full.
	 * 
	 * @return true if the board is full, false otherwise
	 */
	public boolean isBoardFull() {
       boolean res = true;
       for(int i = 0; i < 3; i++){
       	for(int j = 0; j < 3; j++){
       		if (this.board[i][j] == EMPTY){
       			res = false;
			}
		}
	   }
       return res;

       }

       /**
	 * Update the game status if needed (check if there is a win or draw based on
	 * the given row and column position), and return the game status.
	 * 
	 * @param row	an integer representing the row to be checked
	 * @param col	an integer representing the column to be checked
	 * @return  1 if someone won, 2 if it's a draw, and 0 otherwise
	 */
	public int checkGameStatus(int row, int col) {

		if ((0 <= row && row < 3) && (0 <= col && col < 3)) {
			if (this.checkWinRow(row) || this.checkWinCol(col)
					|| this.checkWinDiag()) {
				this.winStatus = 1;
			} else if (this.isBoardFull()) {
				this.winStatus = 2;
			}
		}
		return this.winStatus;
		
	}
	
	/**
	 * Check if the given row number is a 'winning row' (all same marks).
	 * 
	 * @param row	an integer representing the row to be checked
	 * @return true if the given row is a winning row, false otherwise
	 */
	private boolean checkWinRow(int row) {
		
		return (this.board[row][0] == this.board[row][1]) &&
				(this.board[row][1] == this.board[row][2] && this.board[row][0] != EMPTY);
				
	}

	/**
	 * Check if the given column number is a 'winning column' (all same marks).
	 * 
	 * @param col	an integer representing the column to be checked
	 * @return true if the given column is a winning column, false otherwise
	 */	
	private boolean checkWinCol(int col) {
		
		return (this.board[0][col] == this.board[1][col]) && 
				(this.board[1][col] == this.board[2][col] && this.board[0][col] != EMPTY);
		
	}

	/**
	 * Check if there is a 'winning diagonal' (all same marks in a diagonal
	 * line) on this board.
	 * 
	 * @return true if there is a diagonal win, false otherwise
	 */	
	private boolean checkWinDiag() {
		
		return EMPTY;
	}
	
	/**
	 * Get the character associated with the given number.
	 * 
	 * @param num  the number to fetch the associated character for
	 * @return	'_' to represent empty spaces (num=0), 'X' to represent cross
	 * 			(num=1), 'O' to represent circle (num=-1)
	 */
	public char getStringToken(int num) {
		switch (num) {
			case EMPTY: return '_';
			case CROSS: return 'X';
			case CIRCLE: return 'O';
		}
		return 0;
	}
	
	/**
	 * Return string representation of the tic-tac-toe board, with
	 * all marks in the appropriate positions.
	 * 
	 * @return string representation of game board as a text-based grid
	 */
	@Override
	public String toString() {
		
		String s = "";
		for (int row = 0; row < 3; row++) {
	         for (int col = 0; col < 3; col++) {
	        	
	        	// add each token
	            s += this.getStringToken(board[row][col]);
	            
	            //
	            if (col != 2) {
	               s += "|";   // print vertical partition
	            } 
	         }
	         
	         s += "\n";
	         
	      }
	      s += "\n";
	      return s;
	}
	
}

