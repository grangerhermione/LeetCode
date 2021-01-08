package sorting_searching;
/*
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * Median of Two Sorted Arrays:
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, 
 * return the median of the two sorted arrays.
 * Follow up: The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m=nums1.length;
		int n=nums2.length;

		int l=m+n;
		int i=0, j=0, c=0;
		int prev1=0;
		int prev2=0;
		while(i<m || j<n){
			if((i<m && j<n && nums1[i]<=nums2[j]) || (i<m && j>=n)){
				c++;
				if(c==((int)(l/2))){
					prev1=nums1[i];
				}
				if(c==((int)(l/2)+1)){
					prev2=nums1[i];
					break;
				}
				i++;

			}
			else if((j<n && i<m && nums1[i]>nums2[j]) || (j<n && i>=m)){
				c++;
				if(c==((int)(l/2))){
					prev1=nums2[j];
				}
				if(c==((int)(l/2)+1)){
					prev2=nums2[j];
					break;
				}
				j++;

			}

		}
		if(l%2==0){
			return (double)(prev1+prev2)/2;
		}
		return prev2;

	}
}
