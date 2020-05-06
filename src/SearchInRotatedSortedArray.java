/*
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand. 
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */

public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		return binarySearch(nums, 0, nums.length-1, target);
	}

	private int binarySearch(int[] nums, int lo, int high, int target){
		int mid=lo+(high-lo)/2;
		if(lo>high){
			return -1;
		}
		if(nums[mid]==target){
			return mid;
		}
		if(nums[lo]<=nums[mid]){
			if(nums[lo]<=target && target<nums[mid]){
				return binarySearch(nums,lo, mid-1, target);
			}
			else{
				return binarySearch(nums, mid+1, high, target);
			}
		}
		else{
			if(nums[mid]<target && target<=nums[high]){
				return binarySearch(nums, mid+1, high, target);
			}
			else{
				return binarySearch(nums,lo, mid-1, target);
			}
		}

	}
}
