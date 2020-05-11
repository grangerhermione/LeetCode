package recursion_backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/permutations-ii/
 * 
 * Permutations II
 * Given a collection of numbers that might contain duplicates, 
 * return all possible unique permutations.
 */
public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result=new ArrayList<>();
		result.add(new ArrayList<>());
		for(int i=0;i<nums.length;i++){
			Set<List<Integer>> temp=new HashSet<>();
			for(List<Integer> arr: result){
				for(int j=0;j<arr.size()+1;j++){
					arr.add(j, nums[i]);
					List<Integer> l=new ArrayList<>(arr);
					temp.add(l);
					arr.remove(j);

				}
			}
			result = new ArrayList<>(temp);
		}
		return result;
	}

}
