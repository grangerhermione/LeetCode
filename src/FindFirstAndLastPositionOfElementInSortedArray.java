/*
 * Given an array of integers nums sorted in ascending order, find the starting and ending 
 * position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 */

public class FindFirstAndLastPositionOfElementInSortedArray {
	public int[] searchRange(int[] nums, int target) {
		int x=binarySearch(nums, target, 0, nums.length-1);
		if(x==-1){
			return new int[]{-1,-1};
		}
		int result[]=new int[2];
		result[0]=x;
		while(x<nums.length && nums[x]==target){
			x++;
		}
		result[1]=x-1;
		return result;
	}

	private int binarySearch(int[] nums, int target, int lo, int high){
		if(lo>high){
			return -1;
		}
		int mid=lo+(high-lo)/2;
		if(nums[mid]==target){
			if((mid-1)>=0 && (mid-1)<nums.length && nums[mid-1]==target){
				return binarySearch(nums, target, lo, mid-1);
			}
			else{
				return mid;
			}
		}
		else if(nums[mid]<target){
			return binarySearch(nums, target, mid+1, high);
		}
		else{
			return binarySearch(nums, target, lo, mid-1);
		}
	}
}
