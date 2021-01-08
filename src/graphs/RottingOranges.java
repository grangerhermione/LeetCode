package graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/rotting-oranges/
 * 
 * Rotting Oranges:
 * In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  
If this is impossible, return -1 instead.


 */
public class RottingOranges {
	public int orangesRotting(int[][] grid) {
		int count=0;
		int rcount=0;
		Queue<int[]> q=new LinkedList<>();
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if(grid[i][j]==1){
					count++;
				}
				else if(grid[i][j]==2){
					rcount++;
					q.add(new int[]{i, j});
				}
			}
		}
		if(count==0 && rcount==0){
			return 0;
		}
		int target=count+rcount;
		int dx[]=new int[]{-1,0,1,0};
		int dy[]=new int[]{0,-1,0,1};
		int res=0;
		while(!q.isEmpty()){
			int size=q.size();
			if(rcount==target){
				return res;
			}
			for(int i=0;i<size;i++){
				int curr[]=q.poll();
				for(int k=0;k<4;k++){
					int x=curr[0]+dx[k];
					int y=curr[1]+dy[k];
					if(isValid(grid,x,y) && grid[x][y]==1){
						rcount++;
						q.add(new int[]{x, y});
						grid[x][y]=2;
					}
				}
			}
			res++;
		}
		return -1;
	}

	private boolean isValid(int[][] grid, int i, int j){
		if(i>=0 && i<grid.length && j>=0 && j<grid[0].length){
			return true;
		}
		return false;
	}
}
