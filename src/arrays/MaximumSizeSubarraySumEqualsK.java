package arrays;

import java.util.HashMap;

/*
 * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
 * 
 * Maximum Size Subarray Sum Equals k:
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. 
 * If there isn't one, return 0 instead.
 */
public class MaximumSizeSubarraySumEqualsK {
	public int maxSubArrayLen(int[] nums, int k) {
		int sum = 0, max = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			if (sum == k) max = i + 1;
			else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
			if (!map.containsKey(sum)) map.put(sum, i);
		}
		return max;
	}
}
