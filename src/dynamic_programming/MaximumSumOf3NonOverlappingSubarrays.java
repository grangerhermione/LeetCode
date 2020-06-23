package dynamic_programming;
/*
 * https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
 * 
 * Maximum Sum of 3 Non-Overlapping Subarrays:
 * In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.
 * Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.
 * Return the result as a list of indices representing the starting position of each interval 
 * (0-indexed). If there are multiple answers, return the lexicographically smallest one.
 */
public class MaximumSumOf3NonOverlappingSubarrays {
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		// W is an array of sums of windows
		int[] W = new int[nums.length - k + 1];
		int currSum = 0;
		for (int i = 0; i < nums.length; i++) {
			currSum += nums[i];
			if (i >= k) {
				currSum -= nums[i - k];
			}
			if (i >= k - 1) {
				W[i - k + 1] = currSum;
			}
		}

		int[] left = new int[W.length];
		int best = 0;
		for (int i = 0; i < W.length; i++) {
			if (W[i] > W[best]) best = i;
			left[i] = best;
		}

		int[] right = new int[W.length];
		best = W.length - 1;
		for (int i = W.length - 1; i >= 0; i--) {
			if (W[i] >= W[best]) {
				best = i;
			}
			right[i] = best;
		}

		int[] ans = new int[]{-1, -1, -1};
		for (int j = k; j < W.length - k; j++) {
			int i = left[j - k], l = right[j + k];
			if (ans[0] == -1 || W[i] + W[j] + W[l] > W[ans[0]] + W[ans[1]] + W[ans[2]]) {
				ans[0] = i;
				ans[1] = j;
				ans[2] = l;
			}
		}
		return ans;
	}}
