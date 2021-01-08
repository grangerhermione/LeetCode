package dynamic_programming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/frog-jump/
 * 
 * Frog Jump:
 A frog is crossing a river. The river is divided into x units and at each unit there may or 
 may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order, determine if the frog 
is able to cross the river by landing on the last stone. Initially, the frog is on the first 
stone and assume the first jump must be 1 unit.

If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. 
Note that the frog can only jump in the forward direction.

 */
public class FrogJump {
	public boolean canCross(int[] stones) {
		HashMap<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < stones.length; i++) {
			map.put(stones[i], new HashSet<Integer>());
		}
		map.get(0).add(0);
		for (int i = 0; i < stones.length; i++) {
			for (int k : map.get(stones[i])) {
				for (int step = k - 1; step <= k + 1; step++) {
					if (step > 0 && map.containsKey(stones[i] + step)) {
						map.get(stones[i] + step).add(step);
					}
				}
			}
		}
		return map.get(stones[stones.length - 1]).size() > 0;
	}
}
