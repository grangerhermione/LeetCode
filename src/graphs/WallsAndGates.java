package graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/walls-and-gates/	
 * 
 * Walls and Gates:
 * You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you 
may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. 
If it is impossible to reach a gate, it should be filled with INF.
 */
public class WallsAndGates {
	public void wallsAndGates(int[][] rooms) {
		int m=rooms.length;
		if(m==0){
			return;
		}
		int n=rooms[0].length;

		Queue<int[]> q=new LinkedList<>();
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(rooms[i][j]==0){
					q.add(new int[]{i, j});
				}
			}
		}

		int dx[]=new int[]{1, 0, -1, 0};
		int dy[]=new int[]{0, 1, 0, -1};
		while(!q.isEmpty()){
			int []room=q.poll();
			for(int k=0;k<4;k++){
				int r=room[0]+dx[k];
				int c=room[1]+dy[k];

				if(!isValid(r,c,m,n) || rooms[r][c]!=Integer.MAX_VALUE ){
					continue;
				}
				rooms[r][c]=rooms[room[0]][room[1]]+1;
				q.add(new int[]{r, c});
			}
		}
	}

	private boolean isValid(int i, int j, int m, int n){
		return (i>=0 && i<m && j>=0 && j<n);
	}
}
