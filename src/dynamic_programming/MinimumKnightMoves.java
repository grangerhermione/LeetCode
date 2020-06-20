package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/minimum-knight-moves/
 * 
 * Minimum Knight Moves:
 * In an infinite chess board with coordinates from -infinity to +infinity, 
 * you have a knight at square [0, 0].
 * A knight has 8 possible moves it can make, as illustrated below. 
 * Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
 * Return the minimum number of steps needed to move the knight to the square [x, y].  
 * It is guaranteed the answer exists.
 */
public class MinimumKnightMoves {
	public int minKnightMoves(int x, int y) {
		Map<String, Integer> map=new HashMap<>();
		x=Math.abs(x);
		y=Math.abs(y);
		return dfs(x, y, map);

	}

	private int dfs(int x, int y, Map<String, Integer> map){
		String key=x+":"+y;
		if(map.containsKey(key)){
			return map.get(key);
		}
		if(x+y==2){
			return 2;
		}
		else if(x+y==0){
			return 0;
		}

		int steps=1+Math.min(dfs(Math.abs(x-2), Math.abs(y-1), map), dfs(Math.abs(x-1), Math.abs(y-2), map));
		map.put(key, steps);
		return steps;
	}
}
