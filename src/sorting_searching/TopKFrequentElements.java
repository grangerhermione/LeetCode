package sorting_searching;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/top-k-frequent-elements/
 * 
 * Top K Frequent Elements:
 * Given a non-empty array of integers, return the k most frequent elements.
 */
public class TopKFrequentElements {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++){
			map.put(nums[i], map.getOrDefault(nums[i],0)+1);
		}

		PriorityQueue<Map.Entry<Integer,Integer>> queue=new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());

		for(Map.Entry<Integer,Integer> entry: map.entrySet()){
			queue.add(entry);
		}

		int[] result=new int[k];
		for(int i=0;i<k;i++){
			result[i]=queue.poll().getKey();
		}

		return result;
	}
}
