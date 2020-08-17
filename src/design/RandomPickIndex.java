package design;

import java.util.Random;

/*
 * https://leetcode.com/problems/random-pick-index/
 * Random Pick Index:
 * Given an array of integers with possible duplicates, randomly output the index of a 
 * given target number. You can assume that the given target number must exist in the array.
 */
public class RandomPickIndex {
	int[] x;
	Random r;
	public RandomPickIndex(int[] nums) {
		x=nums;
		r=new Random();
	}

	public int pick(int target) {
		int count=1;
		int index=-1;
		for(int i=0;i<x.length;i++){
			if(x[i]==target){
				if(r.nextInt(count++)==0){
					index=i;
				}
			}
		}
		return index;
	}
}
