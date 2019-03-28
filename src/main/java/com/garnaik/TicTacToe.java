package com.garnaik;

/**
 * 
 * @author Garnaik This is the class conatin all the logic for TicTacToe game
 */
public class TicTacToe {
	private int row;
	private int column;
	private String board[][];
	private boolean isSupportMatrix = true;

	public TicTacToe(int row, int column) {
		this.row = row;
		this.column = column;
		if (this.row > 3 || this.column > 3) {
			this.isSupportMatrix = false;
			System.out.println("This Matrix is not supported (" + this.row + " X " + this.column + ").");
			System.out.println("Please enter 3 X 3 Matrix for row & column size");
		}

	}

	/**
	 * @Author Garnaik
	 * @return String[][] Method used to construct the initially game board and each
	 *         cell hold '-'
	 */
	public String[][] constructBoard() {
		this.board = new String[this.row][this.column];
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.column; j++) {
				this.board[i][j] = "-";
			}
		}
		return board;
	}

	/**
	 * @Author Garnaik
	 * @return boolean Method used to print the game board in console
	 */
	public boolean printBoard() {
		boolean isOk = false;
		try {
			for (int i = 0; i < this.row; i++) {
				isOk = true;
				System.out.println();
				for (int j = 0; j < this.column; j++) {
					System.out.print(" | ");
					System.out.print(board[i][j] + " | ");
				}
			}
		} catch (Exception ex) {
			isOk = false;
		}
		System.out.println();
		return isOk;
	}

	/**
	 * @Author Garnaik
	 * @param valueObj
	 * @return String Methiod uised to play the TicTacToe game and logic implemented
	 *         for assign the user enter value to game board. It also check the game
	 *         success or not
	 */
	public String play(EnterValue valueObj) {
		String messageCode = "";
		if (!this.isSupportMatrix) {
			messageCode = "MATRIX_NOT_SUPPORTED";
			return messageCode;
		} else {
			int column = valueObj.getColumn() - 1;
			int row = valueObj.getRow() - 1;
			String boxValue = valueObj.getBoxValue();
			if (column >= this.column || row >= this.row) {
				return messageCode = "INVALID_ROW_COLUMN_VALUE";
			} else if (boxValue == null) {
				return messageCode = "EMPTY_BOX_VALUE";
			} else if (!(boxValue.equals("X") || boxValue.equals("O"))) {
				return messageCode = "INVALID_BOX_VALUE";
			}
			printBoard();
			board[row][column] = boxValue;
			if (gameOver(row, column)) {
				System.out.println("Game over ! Player " + valueObj.getBoxValue());
				messageCode = "SUCCESSFULL";
			}
			printBoard();
			return messageCode;
		}
	}

	/**
	 * @Author Garnaik
	 * @param rowMove    int
	 * @param columnMove int
	 * @return boolean Method used for check the game success for horizontally,
	 *         vertically & diagonally. Logic only support for 3 X 3 Matrix.
	 * @TODO Need to customize for N X N matrix
	 */
	public boolean gameOver(int rowMove, int columnMove) {
		// TODO Need to customize for check N X N Matrix row & column value
		// Currently supporting for 3 X 3 Matrix row & column value

		// Check vertical success
		if ((board[0][columnMove].equals(board[1][columnMove]))
				&& (board[0][columnMove].equals(board[1][columnMove]))) {
			return true;
		}

		// Check Horizontally success
		if ((board[rowMove][0].equals(board[rowMove][1])) && (board[rowMove][0].equals(board[rowMove][2]))) {
			return true;
		}

		// Check Diagonally success
		if ((board[0][0].equals(board[1][1])) && (board[0][0].equals(board[2][2])) && !(board[1][1].equals("-"))) {
			return true;
		}

		if ((board[0][2].equals(board[1][1])) && (board[0][2].equals(board[2][0])) && !(board[1][1].equals("-"))) {
			return true;
		}

		return false;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public String[][] getBoard() {
		return board;
	}

	public void setBoard(String[][] board) {
		this.board = board;
	}

}
