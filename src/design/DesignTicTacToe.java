package design;
/*
 * https://leetcode.com/problems/design-tic-tac-toe/
 * 
 * Design Tic-Tac-Toe:
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row 
wins the game.
 */
public class DesignTicTacToe {
	private int[] rows;
	private int[] cols;
	private int diagonal;
	private int antiDiagonal;
	/** Initialize your data structure here. */
	public DesignTicTacToe(int n) {
		rows=new int[n];
		cols=new int[n];
	}

	/** Player {player} makes a move at ({row}, {col}).
	        @param row The row of the board.
	        @param col The column of the board.
	        @param player The player, can be either 1 or 2.
	        @return The current winning condition, can be either:
	                0: No one wins.
	                1: Player 1 wins.
	                2: Player 2 wins. */
	public int move(int row, int col, int player) {
		int toAdd = player == 1 ? 1 : -1;

		rows[row] += toAdd;
		cols[col] += toAdd;
		if (row == col)
		{
			diagonal += toAdd;
		}

		if (col == (cols.length - row - 1))
		{
			antiDiagonal += toAdd;
		}

		int size = rows.length;
		if (Math.abs(rows[row]) == size ||
				Math.abs(cols[col]) == size ||
				Math.abs(diagonal) == size  ||
				Math.abs(antiDiagonal) == size)
		{
			return player;
		}

		return 0;
	}
}
