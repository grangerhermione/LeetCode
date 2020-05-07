package sorting_searching;
/*
 * https://leetcode.com/problems/find-peak-element/
 * 
 * Find Peak Element:
 * A peak element is an element that is greater than its neighbors.
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of 
 * the peaks is fine.
 * You may imagine that nums[-1] = nums[n] = -∞.
 */
public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		for(int i=0;i<nums.length-1;i++){
			if(nums[i]>nums[i+1]){
				return i;
			}
		}
		return nums.length-1;

	}
}
