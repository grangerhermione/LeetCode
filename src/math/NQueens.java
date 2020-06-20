package math;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/n-queens/
 * 
 * N-Queens:
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such 
 * that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 */
public class NQueens {
	int rows[];

	int hills[];

	int dales[];
	int n;
	int queens[];
	List<List<String>> output = new ArrayList<>();
	public List<List<String>> solveNQueens(int n) {
		this.n = n;
		rows = new int[n];
		hills = new int[4 * n - 1];
		dales = new int[2 * n - 1];
		queens = new int[n];

		backtrack(0);
		return output;
	}

	private boolean isNotUnderAttack(int row, int col) {
		int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
		return (res == 0) ? true : false;
	}

	private void placeQueen(int row, int col) {
		queens[row] = col;
		rows[col] = 1;
		hills[row - col + 2 * n] = 1;  // "hill" diagonals
		dales[row + col] = 1;   //"dale" diagonals
	}

	private void removeQueen(int row, int col) {
		queens[row] = 0;
		rows[col] = 0;
		hills[row - col + 2 * n] = 0;
		dales[row + col] = 0;
	}

	private void addSolution() {
		List<String> solution = new ArrayList<String>();
		for (int i = 0; i < n; ++i) {
			int col = queens[i];
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < col; ++j) sb.append(".");
			sb.append("Q");
			for(int j = 0; j < n - col - 1; ++j) sb.append(".");
			solution.add(sb.toString());
		}
		output.add(solution);
	}

	private void backtrack(int row) {
		for (int col = 0; col < n; col++) {
			if (isNotUnderAttack(row, col)) {
				placeQueen(row, col);
				// if n queens are already placed
				if (row + 1 == n) addSolution();
				// if not proceed to place the rest
				else backtrack(row + 1);
				// backtrack
				removeQueen(row, col);
			}
		}
	}
}
