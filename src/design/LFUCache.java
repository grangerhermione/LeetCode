package design;

import java.util.HashMap;
import java.util.LinkedHashSet;

/*
 * https://leetcode.com/problems/lfu-cache/
 * 
 * LFU Cache:
Design and implement a data structure for Least Frequently Used (LFU) cache. 
It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. 
When the cache reaches its capacity, it should invalidate the least frequently used item before 
inserting a new item. For the purpose of this problem, when there is a tie 
i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

Note that the number of times an item is used is the number of calls to the get and put functions 
for that item since it was inserted. This number is set to zero when the item is removed.
 */
public class LFUCache {
	HashMap<Integer, Integer> vals;
	HashMap<Integer, Integer> counts;
	HashMap<Integer, LinkedHashSet<Integer>> lists;
	int cap;
	int min;

	public LFUCache(int capacity) {
		vals = new HashMap<>();
		counts = new HashMap<>();
		lists = new HashMap<>();
		cap = capacity;
		min = 0;
	}

	public int get(int key) {
		if(!vals.containsKey(key))
			return -1;

		update(key);
		return vals.get(key);
	}

	private void update(int key) {
		int cnt = counts.get(key);
		counts.put(key, cnt + 1);
		lists.get(cnt).remove(key);

		if(cnt == min && lists.get(cnt).size() == 0)
			min++;

		addToList(cnt + 1, key);
	}

	private void addToList(int cnt, int key) {
		if(!lists.containsKey(cnt))
			lists.put(cnt, new LinkedHashSet<>());

		lists.get(cnt).add(key);
	}

	private void evict () {
		int key = lists.get(min).iterator().next(); 
		lists.get(min).remove(key);
		vals.remove(key);
		counts.remove(key);
	}

	public void put(int key, int value) {
		if (cap <= 0)
			return;

		if (vals.containsKey(key)) {
			vals.put(key, value);
			update(key);
			return;
		} 

		if (vals.size() >= cap) 
			evict();

		vals.put(key, value);
		counts.put(key, 1);
		addToList(1, key);
		min = 1;
	}
}
