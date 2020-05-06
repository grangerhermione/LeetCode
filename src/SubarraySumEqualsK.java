import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers and an integer k, you need to find the total number of 
 * continuous subarrays whose sum equals to k.
 */
public class SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map=new HashMap<>();
		map.put(0,1);
		
		int count=0;
		int sum=0;
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];
			int n=map.getOrDefault(sum-k, 0);
			count+=n;
			map.put(sum, map.getOrDefault(sum, 0)+1);
		}
		return count;
	}
}
