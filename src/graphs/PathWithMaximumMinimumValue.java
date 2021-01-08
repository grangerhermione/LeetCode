package graphs;

import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/path-with-maximum-minimum-value/
 * 
 * Path With Maximum Minimum Value:
 * Given a matrix of integers A with R rows and C columns, find the maximum score of a 
 * path starting at [0,0] and ending at [R-1,C-1].

The score of a path is the minimum value in that path.  For example, the value of the path 
8 →  4 →  5 →  9 is 4.

A path moves some number of times from one visited cell to any neighbouring unvisited cell in 
one of the 4 cardinal directions (north, east, west, south).
 */
public class PathWithMaximumMinimumValue {
	static class Cell {
		int i, j, val;
		Cell(int i, int j, int val) { this.i = i; this.j = j; this.val = val; }
	}

	static int[][] moves = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

	public int maximumMinimumPath(int[][] A) {
		PriorityQueue<Cell> q = new PriorityQueue<>((a, b) -> b.val - a.val);
		q.add(new Cell(0, 0, A[0][0]));
		boolean[][] discovered = new boolean[A.length][A[0].length];
		discovered[0][0] = true;
		int min = A[0][0];
		while (!q.isEmpty()) {
			Cell bestMove = q.poll();
			if (bestMove.val < min) min = bestMove.val;

			if (bestMove.i == A.length - 1 && bestMove.j == A[0].length - 1) {
				return min;
			}
			for (int[] move : moves) {
				int i = bestMove.i + move[0];
				int j = bestMove.j + move[1];
				if (i >= 0 && i < A.length && j >= 0 && j < A[0].length && !discovered[i][j]) {
					q.add(new Cell(i, j, A[i][j]));
					discovered[i][j] = true;
				}
			}
		}
		return -1;
	}
}
