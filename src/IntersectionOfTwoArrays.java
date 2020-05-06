import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Given two arrays, write a function to compute their intersection.
 */
public class IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1=new HashSet<>();
		Set<Integer> set2=new HashSet<>();
		for(int x:nums1){
			set1.add(x);
		}
		for(int x:nums2){
			set2.add(x);
		}

		int result[]=new int[set1.size()];
		int k=0;
		for(Integer x: set2){
			if(set1.contains(x)){
				result[k++]=x;
			}
		}
		return Arrays.copyOf(result,k);
	}
}
