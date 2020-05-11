package recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/subsets/
 * 
 * Subsets:
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		if(nums==null || nums.length==0){
			return null;
		}
		List<List<Integer>> result=new ArrayList<>();
		result.add(new ArrayList<>());

		for(int i=0;i<nums.length;i++){
			List<List<Integer>> temp=new ArrayList<>();
			for(int j=0;j<result.size();j++){
				temp.add(new ArrayList<>(result.get(j)));
			}
			for(int j=0;j<temp.size();j++){
				temp.get(j).add(nums[i]);
			}
			result.addAll(temp);
		}
		return result;
	}
}
