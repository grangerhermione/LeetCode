package arrays;
/*
 * https://leetcode.com/problems/sort-colors/
 * Sort Colors:
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of 
 * the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
public class SortColors {
	public void sortColors(int[] nums) {
		int i=0,j=0,k=nums.length-1;
		while(j<=k){
			if(nums[j]==0){
				int temp=nums[i];
				nums[i]=nums[j];
				nums[j]=temp;
				i++;
				j++;
			}
			else if(nums[j]==2){
				int temp=nums[j];
				nums[j]=nums[k];
				nums[k]=temp;
				k--;
			}
			else{
				j++;
			}
		}
	}
}
