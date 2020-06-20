package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/number-of-islands-ii/
 * 
 * Number of Islands II:
 * A 2d grid map of m rows and n columns is initially filled with water. 
 * We may perform an addLand operation which turns the water at position (row, col) into a land. 
 * Given a list of positions to operate, count the number of islands after each addLand operation. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or 
 * vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslandsII {
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		List<Integer> result = new ArrayList<>();
		if(m <= 0 || n <= 0) return result;

		int count = 0;                      
		int[] roots = new int[m * n];       
		Arrays.fill(roots, -1);            
		int dx[]=new int[]{0, 1, 0, -1};
		int dy[]=new int[]{1, 0, -1, 0};
		for(int[] p : positions) {
			int root = n * p[0] + p[1];     
			if (roots[root] != -1) {    
				result.add(count);
				continue;
			}
			roots[root] = root;             
			count++;

			for(int i=0;i<4;i++) {
				int x = p[0] + dx[i]; 
				int y = p[1] + dy[i];
				int nb = n * x + y;
				if(x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1) {
					continue;
				}
				int rootNb = findIsland(roots, nb);
				if(root != rootNb) {        
					roots[root] = rootNb;   
					root = rootNb;          
					count--;               
				}
			}

			result.add(count);
		}
		return result;
	}

	public int findIsland(int[] roots, int id) {
		while(id != roots[id]) id = roots[id];
		return id;
	}
}
