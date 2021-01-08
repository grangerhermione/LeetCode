package sorting_searching;
/*
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * 
 * Two Sum II - Input array is sorted:
 * Given an array of integers that is already sorted in ascending order, 
 * find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2.
 */
public class TwoSumII {
	public int[] twoSum(int[] numbers, int target) {
		int result[]=new int[2];
		int i=0;
		int j=numbers.length-1;
		while(i<j){
			if(numbers[i]+numbers[j]==target){
				result[0]=i+1;
				result[1]=j+1;
				return result;
			}
			if(numbers[i]+numbers[j]<target){
				i++;
			}
			else{
				j--;
			}
		}
		return result;
	}
}
