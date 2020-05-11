package recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/permutations/
 * 
 * Permutations
 * Given a collection of distinct integers, return all possible permutations.
 */
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result=new ArrayList<>();

		result.add(new ArrayList<Integer>());
		for(int i=0;i<nums.length;i++){
			List<List<Integer>> curr=new ArrayList<>();
			for(List<Integer> arr: result){
				for(int j=0;j<arr.size()+1;j++){
					arr.add(j,nums[i]);

					List<Integer> temp=new ArrayList<>(arr);
					curr.add(temp);


					arr.remove(j);
				}
			}

			result.clear();
			result.addAll(curr);

		}
		return result;

	}
}
