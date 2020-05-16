package graphs;
/*
 * https://leetcode.com/problems/number-of-islands/
 * Number of Islands:
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands 
 * horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		if(grid==null || grid.length==0){
			return 0;
		}
		int rows=grid.length;
		int cols=grid[0].length;
		int count=0;
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(grid[i][j]=='1'){
					count++;
					DFS(grid,i,j);
				}
			}
		}
		return count;
	}

	private void DFS(char[][] grid, int i, int j){
		int rows=grid.length;
		int cols=grid[0].length;

		if(i<0 || i>=rows || j<0 || j>=cols || grid[i][j]!='1'){
			return;
		}
		grid[i][j]='0';
		DFS(grid,i-1,j);
		DFS(grid,i+1,j);
		DFS(grid,i,j-1);
		DFS(grid,i,j+1);
	}
}
