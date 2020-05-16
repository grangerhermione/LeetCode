package arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/interval-list-intersections/
 * Interval List Intersections:
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint 
 * and in sorted order.
 * Return the intersection of these two interval lists.
 */
public class IntervalListIntersections {
	public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res=new ArrayList<>();
        int i=0,j=0;
        while(i<A.length && j<B.length){
            int[] int1=A[i];
            int[] int2=B[j];
            
            int[] temp=intersection(int1, int2);
            if(temp[0]<=temp[1]){
                res.add(temp);
            }
            if(int1[1]>=int2[1]){
                j++;
            }
            else {
                i++;
            }
           
        }
        
        return res.toArray(new int[res.size()][]);
    }
    
    private int[] intersection(int[] a, int[] b){
        int res[]=new int[2];
        res[0] = Math.max(a[0],b[0]);
        res[1] = Math.min(a[1],b[1]);
        return res;
    }
}
