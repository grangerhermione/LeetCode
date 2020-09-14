package graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 * 
 * Shortest Path in Binary Matrix:
 *In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:

Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
C_1 is at location (0, 0) (ie. has value grid[0][0])
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.


 */
public class ShortestPathInBinaryMatrix {
	public int shortestPathBinaryMatrix(int[][] grid) {
		int n=grid.length;
		if(grid[0][0]!=0 || grid[n-1][n-1]!=0){
			return -1;
		}
		Queue<int[]> queue=new LinkedList<>();
		boolean visited[][]=new boolean[n][n];
		queue.add(new int[]{0,0});
		visited[0][0]=true;
		int dx[]=new int[]{-1, -1, -1, 0, 0, 1, 1, 1 };
		int dy[]=new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
		int result=0;
		while(!queue.isEmpty()){
			int size=queue.size();
			for(int i=0;i<size;i++){
				int curr[]=queue.poll();
				if(curr[0]==n-1 && curr[1]==n-1){
					return result+1;
				}
				for(int k=0;k<8;k++){
					int x=curr[0]+dx[k];
					int y=curr[1]+dy[k];
					if(isValid(x, y, n) && !visited[x][y] && grid[x][y]==0){
						queue.add(new int[]{x,y});
						visited[x][y]=true;
					}
				}
			}
			result++;
		}
		return -1;
	}

	private boolean isValid(int i, int j, int n){
		if(i>=0 && i<n && j>=0 && j<n){
			return true;
		}
		return false;
	}
}
