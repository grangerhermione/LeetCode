/*
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once 
 * and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input 
array in-place with O(1) extra memory.
 */

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		int n = nums.length;
		if(n==0 || n==1){
			return n;
		}
		int i=0;
		for(int j=0;j < n-1;j++){
			if(nums[j]!=nums[j+1]){
				nums[i++]=nums[j];
			}   
		}

		nums[i++]=nums[n-1];

		return i;
	}
}
