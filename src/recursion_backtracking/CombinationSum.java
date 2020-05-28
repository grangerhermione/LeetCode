package recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/combination-sum/
 * Combination Sum:
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result=new ArrayList<>();
		List<Integer> temp=new ArrayList<>();
		recurse(candidates, target, 0, 0, temp, result);
		return result;
	}

	private void recurse(int[] candidates, int target, int index, int sum, List<Integer> temp, List<List<Integer>> result){
		if(sum>target){
			return;
		}
		if(sum==target){
			result.add(new ArrayList<>(temp));
			return;
		}

		for(int i=index;i<candidates.length;i++){
			temp.add(candidates[i]);
			recurse(candidates, target, i, sum+candidates[i], temp, result);
			temp.remove(temp.size()-1);
		}
	}
}
