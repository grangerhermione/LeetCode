package arrays;
/*
 * https://leetcode.com/problems/next-permutation/
 * 
 * Next Permutation
 * Implement next permutation, which rearranges numbers into the lexicographically next 
 * greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order 
 * (ie, sorted in ascending order).
 * The replacement must be in-place and use only constant extra memory.
 */

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		int i=nums.length-2;
		while(i>=0 && nums[i] >= nums[i+1]){
			i--;
		}
		if(i>=0){
			int j=nums.length-1;
			while(j>=0 && nums[i]>=nums[j]){
				j--;
			}
			swap(nums, i, j);

		}

		reverse(nums, i+1);

	}

	private void swap(int[] nums, int i, int j){
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}

	private void reverse(int nums[], int begin){
		int i=begin, j=nums.length-1;
		while(i<j){
			swap(nums, i, j);
			i++;
			j--;
		}
	}
}
