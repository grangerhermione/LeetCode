package recursion_backtracking;
/*
 * https://leetcode.com/problems/target-sum/
 * Target Sum:
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its 
 * new symbol.
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 */
public class TargetSum {
	int result;
	public int findTargetSumWays(int[] nums, int S) {
		dfs(nums, S, 0, 0);
		return result;
	}

	private void dfs(int nums[], int S, int index, int sum){
		if(index==nums.length){
			if(sum==S){
				result++;
			}
			return;
		}
		int curr=nums[index];
		dfs(nums, S, index+1, sum+curr);
		dfs(nums, S, index+1, sum-curr);
	}
}
