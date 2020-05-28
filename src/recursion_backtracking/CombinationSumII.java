package recursion_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/combination-sum-ii/
 * Combination Sum II:
 * Given a collection of candidate numbers (candidates) and a target number (target), 
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 */
public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result=new ArrayList<>();
		List<Integer> temp=new ArrayList<>();
		recurse(candidates, target, 0, temp, result);
		return result;
	}

	private void recurse(int[] candidates, int target, int index, List<Integer> temp, List<List<Integer>> result){
		if(target<0){
			return;
		}
		if(target==0){
			result.add(new ArrayList<>(temp));
			return;
		}
		for(int i=index;i<candidates.length;i++){
			if(i>index && candidates[i]==candidates[i-1]){
				continue;
			}
			temp.add(candidates[i]);
			recurse(candidates, target-candidates[i], i+1, temp, result);
			temp.remove(temp.size()-1);

		}
	}
}
