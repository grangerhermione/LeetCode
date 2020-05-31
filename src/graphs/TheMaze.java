package graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/the-maze/
 * The Maze:
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by 
 * rolling up, down, left or right, but it won't stop rolling until hitting a wall. 
 * When the ball stops, it could choose the next direction.
 * Given the ball's start position, the destination and the maze, determine whether the ball 
 * could stop at the destination.
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. 
 * You may assume that the borders of the maze are all walls. 
 * The start and destination coordinates are represented by row and column indexes.
 */
public class TheMaze {
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		int m=maze.length;
		int n=maze[0].length;
		boolean visited[][]=new boolean[m][n];
		Queue<int[]> q=new LinkedList<>();
		int dir[][]=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
		q.add(start);
		visited[start[0]][start[1]]=true;
		while(!q.isEmpty()){
			int[] curr=q.remove();
			if(curr[0]==destination[0] && curr[1]==destination[1]){
				return true;
			}
			for(int k=0;k<dir.length;k++){
				int dx=curr[0]+dir[k][0];
				int dy=curr[1]+dir[k][1];
				while(dx>=0 && dx<m && dy>=0 && dy<n && maze[dx][dy]==0){
					dx+=dir[k][0];
					dy+=dir[k][1];
				}
				if(!visited[dx-dir[k][0]][dy-dir[k][1]]){
					visited[dx-dir[k][0]][dy-dir[k][1]]=true;
					q.add(new int[]{dx-dir[k][0],dy-dir[k][1]});
				}
			}
		}
		return false;
	}
}
