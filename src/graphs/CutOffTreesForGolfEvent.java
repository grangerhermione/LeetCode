package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.com/problems/cut-off-trees-for-golf-event/
 * 
 * Cut Off Trees for Golf Event:
 * You are asked to cut off trees in a forest for a golf event. 
 * The forest is represented as a non-negative 2D map, in this map:
 * 0 represents the obstacle can't be reached.
 * 1 represents the ground can be walked through.
 * The place with number bigger than 1 represents a tree can be walked through, 
 * and this positive number represents the tree's height. 
 * 
 * In one step you can walk in any of the four directions top, bottom, left and right also 
 * when standing in a point which is a tree you can decide whether or not to cut off the tree.
 * You are asked to cut off all the trees in this forest in the order of tree's height - always 
 * cut off the tree with lowest height first. And after cutting, the original place has the tree 
 * will become a grass (value 1).
 * You will start from the point (0, 0) and you should output the minimum steps you need to 
 * walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.
 * You are guaranteed that no two trees have the same height and there is at least one 
 * tree needs to be cut off.
 */
public class CutOffTreesForGolfEvent {
	public int cutOffTree(List<List<Integer>> forest) {
		List<int[]> trees=new ArrayList<>();
		int r=forest.size();
		int c=forest.get(0).size();
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(forest.get(i).get(j)>1){
					trees.add(new int[]{i, j, forest.get(i).get(j)});
				}
			}
		}
		Collections.sort(trees, (a,b)->a[2]-b[2]);
		int sr=0, sc=0;
		int count=0;
		for(int[] tree: trees){
			int dist=bfs(forest, sr, sc, tree[0], tree[1]);
			if(dist<0){
				return -1;
			}
			count+=dist;
			sr=tree[0];
			sc=tree[1];
		}
		return count;
	}

	private int bfs(List<List<Integer>> forest, int sr, int sc, int tr, int tc){
		int r=forest.size();
		int c=forest.get(0).size();
		Queue<int[]> queue=new LinkedList<>();
		queue.add(new int[]{sr, sc, 0});
		boolean visited[][]=new boolean[r][c];
		int dx[]=new int[]{0,1,0,-1};
		int dy[]=new int[]{1, 0, -1, 0};
		while(!queue.isEmpty()){
			int curr[]=queue.poll();
			if(tr==curr[0] && tc==curr[1]){
				return curr[2];
			}
			for(int k=0;k<4;k++){
				int x=curr[0]+dx[k];
				int y=curr[1]+dy[k];
				if(isValid(x,y,r,c) && !visited[x][y] && forest.get(x).get(y)>0){
					visited[x][y]=true;
					queue.add(new int[]{x, y, curr[2]+1});
				}
			}
		}
		return -1;
	}

	private boolean isValid(int x, int y, int r, int c){
		if(x>=0 && x<r && y>=0 && y<c){
			return true;
		}
		return false;
	}
}
