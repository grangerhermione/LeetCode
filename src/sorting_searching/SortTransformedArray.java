package sorting_searching;
/*
 * https://leetcode.com/problems/sort-transformed-array/
 * 
 * Sort Transformed Array:
 * Given a sorted array of integers nums and integer values a, b and c. 
 * Apply a quadratic function of the form f(x) = ax2 + bx + c to each element x in the array.
 * The returned array must be in sorted order.
 */
public class SortTransformedArray {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		int n = nums.length;
		int[] sorted = new int[n];
		int i = 0, j = n - 1;
		int index = a >= 0 ? n - 1 : 0;
		while (i <= j) {
			int quadi=quad(nums[i], a, b, c);
			int quadj=quad(nums[j], a, b, c);
			if (a >= 0) {
				if(quadi >= quadj){
					sorted[index--]=quadi;
					i++;
				}
				else{
					sorted[index--]=quadj;
					j--;
				}
			} else {
				if(quadi >= quadj){
					sorted[index++]=quadj;
					j--;
				}
				else{
					sorted[index++]=quadi;
					i++;
				}
			}
		}
		return sorted;
	}

	private int quad(int x, int a, int b, int c) {
		return a * x * x + b * x + c;
	}
}
