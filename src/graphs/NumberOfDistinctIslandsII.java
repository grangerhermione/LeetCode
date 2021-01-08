package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 * https://leetcode.com/problems/number-of-distinct-islands-ii/
 * 
 * Number of Distinct Islands II:
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's 
 * (representing land) connected 4-directionally (horizontal or vertical.) 
 * You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another 
if they have the same shape, or have the same shape after rotation (90, 180, or 270 degrees only) 
or reflection (left/right direction or up/down direction).
 */
public class NumberOfDistinctIslandsII {
	public int numDistinctIslands2(int[][] grid) {
		Set<String> islands = new HashSet<>();
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j <grid[0].length; j++)
				if (grid[i][j] == 1) {
					List<int[]> cells = new LinkedList<>();
					dfs(i, j, grid, cells);
					islands.add(norm(cells));
				}
		return islands.size();
	}

	void dfs(int i, int j, int[][] a, List<int[]> cells) {
		if (i < 0 || i >= a.length || j < 0 || j >= a[0].length || a[i][j] != 1) return;
		cells.add(new int[]{i, j});
		a[i][j] = -1;
		dfs(i + 1, j, a, cells); dfs(i - 1, j, a, cells);
		dfs(i, j + 1, a, cells); dfs(i, j - 1, a, cells);
	}

	String norm(List<int[]> cells) {
		TreeSet<String> normShapes = new TreeSet<>();
		for (int i = -1; i <= 1; i += 2)
			for (int j = -1; j <= 1; j += 2) {
				List<int[]> s1 = new ArrayList<>(), s2 = new ArrayList<>();
				for (int[] cell : cells) {
					int x = cell[0], y = cell[1];
					s1.add(new int[]{i * x, j * y});
					s2.add(new int[]{i * y, j * x});
				}
				for (List<int[]> s : Arrays.asList(s1, s2)) {
					s.sort(new Comparator<int[]>() {
						@Override public int compare(int[] o1, int[] o2) {
							return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
						}
					});
					int x = s.get(0)[0], y = s.get(0)[1];
					StringBuilder b = new StringBuilder();
					for (int[] p : s)
						b.append(p[0] - x).append(":").append(p[1] - y).append(":");
					normShapes.add(b.toString());
				}
			}
		return normShapes.first();
	}
}
