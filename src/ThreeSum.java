import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 */

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result=new ArrayList<>();
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++){
			int j=i+1;
			int k=nums.length-1;
			if(i>0 && nums[i]==nums[i-1]){
				continue;
			}
			while(j<k){
				if(k<nums.length-1 && nums[k]==nums[k+1]){
					k--;
					continue;
				}
				if(nums[i]+nums[j]+nums[k]<0){
					j++;
				}
				else if(nums[i]+nums[j]+nums[k]>0){
					k--;
				}
				else{
					List<Integer> list=new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[k]);
					result.add(list);
					j++;
					k--;
				}
			}
		}
		return result;
	}
}
