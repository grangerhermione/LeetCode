package arrays;
/*
 * https://leetcode.com/problems/missing-number/
 * 
 * Missing Number:
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 * find the one that is missing from the array.
 */
public class MissingNumber {
	public int missingNumber(int[] nums) {
		int sum=0;
		for(int i=0; i<nums.length; i++){
			sum+=nums[i];
		}

		int n=nums.length;
		return n*(n+1)/2-sum;
	}
}
