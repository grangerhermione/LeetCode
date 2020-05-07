package sorting_searching;
/*
 * https://leetcode.com/problems/merge-sorted-array/
 * 
 * Merge Sorted Array:
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 */
public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int k = m+n-1;
		while(m>0 && n>0){
			if(nums1[m-1] < nums2[n-1]){
				nums1[k--]=nums2[n-1];
				n--;
			}
			else{
				nums1[k--]=nums1[m-1];
				m--;
			}
		}
		while(n>0){
			nums1[k--]=nums2[n-1];
			n--;
		}

	}
}
