package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/*
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 * Insert Delete GetRandom O(1) - Duplicates allowed:
Design a data structure that supports all following operations in average O(1) time.

Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. 
The probability of each element being returned is linearly related to the number of same 
value the collection contains.
 */
public class InsertDeleteGetRandomWithDuplicates {
	Map<Integer, Set<Integer>> valueMap;
	List<Integer> list;
	Random r;
	/** Initialize your data structure here. */
	public InsertDeleteGetRandomWithDuplicates() {
		valueMap=new HashMap<>();
		list=new ArrayList<>();
		r=new Random();
	}

	/** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
	public boolean insert(int val) {
		if(!valueMap.containsKey(val)){
			valueMap.put(val, new LinkedHashSet<>());
		}
		valueMap.get(val).add(list.size());
		list.add(val);
		if(valueMap.get(val).size()==1){
			return true;
		}
		return false;
	}

	/** Removes a value from the collection. Returns true if the collection contained the specified element. */
	public boolean remove(int val) {
		if(!valueMap.containsKey(val) || valueMap.get(val).size()==0){
			return false;
		}
		Set<Integer> index=valueMap.get(val);
		int removeIndex = index.iterator().next();
		valueMap.get(val).remove(removeIndex);
		int lastElem=list.get(list.size()-1);
		list.set(removeIndex, lastElem);
		valueMap.get(lastElem).add(removeIndex);
		valueMap.get(lastElem).remove(list.size()-1);
		list.remove(list.size()-1);
		return true;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		return list.get(r.nextInt(list.size()));
	}
}
