package design;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 * Insert Delete GetRandom O(1):
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. 
Each element must have the same probability of being returned.
 */
public class InsertDeleteGetRandom {
	Map<Integer,Integer> valueMap;
	Map<Integer,Integer> indexMap;
	Random r;
	/** Initialize your data structure here. */
	public InsertDeleteGetRandom() {
		valueMap=new HashMap<>();
		indexMap=new HashMap<>();
		r=new Random();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if(valueMap.containsKey(val)){
			return false;
		}
		valueMap.put(val, valueMap.size());
		indexMap.put(indexMap.size(), val);
		return true;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if(!valueMap.containsKey(val)){
			return false;
		}
		int index=valueMap.get(val);
		valueMap.remove(val);
		indexMap.remove(index);

		Integer lastElement = indexMap.get(indexMap.size());
		if(lastElement!=null){
			valueMap.put(lastElement, index);
			indexMap.put(index,lastElement);
		}
		return true;

	}

	/** Get a random element from the set. */
	public int getRandom() {
		if(valueMap.isEmpty()){
			return -1;
		}
		if(valueMap.size()==1){
			return indexMap.get(0);
		}

		int index= r.nextInt(valueMap.size());

		return indexMap.get(index);
	}
}
