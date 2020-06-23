package sorting_searching;

import java.util.ArrayList;

/*
 * https://leetcode.com/problems/insert-interval/
 * 
 * Insert Interval:
 * Given a set of non-overlapping intervals, insert a new interval into the intervals 
 * (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 */
public class InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		ArrayList<int[]> result=new ArrayList<>();
		int i=0;
		while(i<intervals.length && intervals[i][1]<newInterval[0]){
			result.add(intervals[i]);
			i++;
		}
		while(i<intervals.length && intervals[i][0]<=newInterval[1]){
			newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			i++;
		}
		result.add(newInterval);

		while(i<intervals.length){
			result.add(intervals[i]);
			i++;
		}
		return result.toArray(new int[result.size()][2]);
	}
}
