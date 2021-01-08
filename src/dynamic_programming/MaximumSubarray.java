package dynamic_programming;
/*
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * Maximum Subarray:
 * Given an integer array nums, find the contiguous subarray (containing at least one number) 
 * which has the largest sum and return its sum.
 */
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int maxSoFar=Integer.MIN_VALUE;
		int max=0;
		for(int i=0;i<nums.length;i++){
			max+=nums[i];
			if(max>maxSoFar){
				maxSoFar=max;
			}
			if(max<0){
				max=0;
			}
		}
		return maxSoFar;
	}
}
