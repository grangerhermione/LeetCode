package sorting_searching;
/*
 * https://leetcode.com/problems/missing-element-in-sorted-array/
 * 
 * Missing Element in Sorted Array:
 * Given a sorted array A of unique numbers, find the K-th missing number starting from the 
 * leftmost number of the array.
 */
public class MissingElementInASortedArray {
	public int missingElement(int[] nums, int k) {
        int n=nums.length;
        if(k>missing(n-1, nums)){
            return nums[n-1]+k-missing(n-1, nums);
        }
        
        int index=1;
        while(missing(index, nums)<k){
            index++;
        }
        return nums[index-1]+k-missing(index-1, nums);
    }
    
    private int missing(int index, int nums[]){
        return nums[index]-nums[0]-index;
    }
}
