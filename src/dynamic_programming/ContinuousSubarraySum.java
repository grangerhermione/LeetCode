package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/continuous-subarray-sum/
 * 
 * Continuous Subarray Sum:
 * Given a list of non-negative numbers and a target integer k, 
 * write a function to check if the array has a continuous subarray of size at least 2 
 * that sums up to a multiple of k, that is, sums up to n*k where n is also an integer.
 */
public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(k!=0){
                sum=sum%k;
            }
            if(map.containsKey(sum)){
                if(i-map.get(sum)>1){
                    return true;
                }
            }
            else{
                map.put(sum, i);
            }
        }
        return false;
	}
}
