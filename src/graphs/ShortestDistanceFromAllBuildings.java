package graphs;

import java.util.LinkedList;

/*
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/
 * Shortest Distance from All Buildings:
 * You want to build a house on an empty land which reaches all buildings in the shortest 
 * amount of distance. You can only move up, down, left and right. 
 * You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
 */
public class ShortestDistanceFromAllBuildings {
	int m,n;
	public int shortestDistance(int[][] grid) {
		m=grid.length;
		n=grid[0].length;
		int[][] distance=new int[m][n];
		int[][] reach=new int[m][n];

		int numBuildings=0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j]==1){
					bfs(grid, reach, distance, i, j);
					numBuildings++;
				}
			}
		}

		int result=Integer.MAX_VALUE;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j]==0 && reach[i][j]==numBuildings){
					result=Math.min(result, distance[i][j]);
				}
			}
		}
		return result==Integer.MAX_VALUE?-1:result;
	}

	private void bfs(int[][] grid, int[][] reach, int[][] distance, int i, int j){
		int dx[]=new int[]{-1, 0, 1, 0};
		int dy[]=new int[]{0, -1, 0, 1};

		LinkedList<int[]> queue=new LinkedList<>();
		LinkedList<Integer> distQueue=new LinkedList<>();

		queue.add(new int[]{i,j});
		distQueue.add(1);

		while(!queue.isEmpty()){
			int[] curr=queue.poll();
			int dist= distQueue.poll();

			for(int k=0;k<4;k++){
				int x = curr[0]+dx[k];
				int y = curr[1]+dy[k];

				if(isValid(x, y) && grid[x][y]==0){
					grid[x][y]=-1;

					queue.add(new int[]{x,y});
					distQueue.add(dist+1);

					reach[x][y]++;
					distance[x][y] += dist;
				}

			}
		}

		for(int p=0;p<m;p++){
			for(int q=0;q<n;q++){
				if(grid[p][q]==-1){
					grid[p][q]=0;
				}
			}
		}
	}

	private boolean isValid(int x, int y){
		return (x>=0 && x<m && y>=0 && y<n);
	}

}
