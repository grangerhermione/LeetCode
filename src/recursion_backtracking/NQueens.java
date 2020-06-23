package recursion_backtracking;

import java.util.LinkedList;
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
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new LinkedList<>();
		if (n <= 0) { return res; } 
		// build chessboard @mat(=matrix)
		char[][] mat = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = '.';
			}
		}
		helper(mat, 0, res);
		return res;
	}
	private void helper(char[][] mat, int row, List<List<String>> res) {
		// reach solution
		if (row == mat.length) {
			res.add(builder(mat));
			return;
		}
		for (int i = 0; i < mat.length; i++) {
			// try
			mat[row][i] = 'Q';
			// if possible
			if (isValid(mat, row, i)) {
				helper(mat, row + 1, res);
			}
			// un-try
			mat[row][i] = '.';
		}
		return;
	}
	private boolean isValid(char[][] mat, int x, int y) {
		// only check rows above current one
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < mat.length; j++) {
				// not need to check current position
				if (i == x && j == y) { 
					continue;
				}
				// if 'Q' in the same col or the diagonal line, return false
				if ((j == y || Math.abs(x - i) == Math.abs(y - j)) && mat[i][j] == 'Q') {
					return false;
				} 
			}
		}
		return true;
	}
	// build solution from temporary chessboard
	private List<String> builder(char[][] mat) {
		List<String> tmp = new LinkedList<>();
		for (int i = 0; i < mat.length; i++) {
			String t = new String(mat[i]);
			tmp.add(t);
		}
		return tmp;
	}
}
