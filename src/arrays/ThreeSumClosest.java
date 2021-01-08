package arrays;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/3sum-closest/
 * 
 * 3Sum Closest:
 * Given an array nums of n integers and an integer target, find three integers in nums such 
 * that the sum is closest to target. Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		int diff=Integer.MAX_VALUE;
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++){
			int j=i+1;
			int k=nums.length-1;
			// if(i>0 && nums[i]==nums[i-1]){
			//     continue;
			// }
			while(j<k){
				// if(k<nums.length-1 && nums[k]==nums[k+1]){
				//     k--;
				//     continue;
				// }
				int sum=nums[i]+nums[j]+nums[k];
				if(Math.abs(sum-target)<Math.abs(diff)){
					diff=target-sum;
				}
				if(sum<target){
					j++;
				}
				else{
					k--;
				}
			}
		}
		return target-diff;
	}
}
