package arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/find-k-closest-elements/
 * Find K Closest Elements:
 * Given a sorted array arr, two integers k and x, find the k closest elements to x in the array. 
 * The result should also be sorted in ascending order. If there is a tie, 
 * the smaller elements are always preferred.
 */
public class FindKClosestElements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		int h=arr.length-k;
		int l=0;
		while(l<h){
			int mid=(l+h)/2;
			if(x-arr[mid]<=arr[k+mid]-x){
				h=mid;
			}
			else{
				l=mid+1;
			}
		}
		List<Integer> result=new ArrayList<>(k);
		for(int i=h;i<h+k;i++){
			result.add(arr[i]);
		}
		return result;
	}
}
