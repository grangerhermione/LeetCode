import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given two arrays, write a function to compute their intersection.
 */
public class IntersectionOfTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map=new HashMap<>();
		for(int x:nums1){
			if(map.containsKey(x)){
				map.put(x,map.get(x)+1);
			}
			else{
				map.put(x,1);
			}
		}
		List<Integer> arr = new ArrayList<>();  
		for(int x:nums2){
			if(map.containsKey(x) && map.get(x)!=0){
				map.put(x,map.get(x)-1);
				arr.add(x);
			}

		}


		int[] array = new int[arr.size()];
		for(int i=0;i<arr.size();i++){
			array[i]=arr.get(i);
		}
		return array;
	}
}
