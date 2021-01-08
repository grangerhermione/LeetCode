package graphs;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/number-of-distinct-islands/
 * 
 * Number of Distinct Islands:
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid
are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only 
if one island can be translated (and not rotated or reflected) to equal the other.
 */
public class NumberOfDistinctIslands {
	public int numDistinctIslands(int[][] grid) {
		int m=grid.length;
		int n=grid[0].length;
		boolean visited[][]=new boolean[m][n];
		Set<String> set=new HashSet<>();

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(!visited[i][j] && grid[i][j]==1){
					StringBuilder sb=new StringBuilder();
					dfs(i, j, grid, visited, sb, "o");
					visited[i][j]=true;
					set.add(sb.toString());
				}
			}
		}
		return set.size();
	}

	private void dfs(int i, int j, int[][] grid, boolean visited[][], StringBuilder sb, String direction){
		int m=grid.length;
		int n=grid[0].length;
		if(isValid(i, j, m , n) && !visited[i][j] && grid[i][j]==1){
			sb.append(direction);
			visited[i][j]=true;
			dfs(i+1, j, grid, visited, sb,"r");
			dfs(i-1, j, grid, visited, sb,"l");
			dfs(i, j+1, grid, visited, sb,"d");
			dfs(i, j-1, grid, visited, sb,"u");
			sb.append("b");
		}
	}

	private boolean isValid(int i, int j, int m, int n){
		if(i>=0 && i<m && j>=0 && j<n){
			return true;
		}
		return false;
	}
}
