package arrays;
/*
 * https://leetcode.com/problems/move-zeroes/
 * 
 * Move Zeroes
 * Given an array nums, write a function to move all 0's to the end of it 
 * while maintaining the relative order of the non-zero elements.
 */
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j] != 0){
                nums[i++] = nums[j];
            }
        }
        for(;i<nums.length;i++){
            nums[i] = 0;
        }
    }
}
