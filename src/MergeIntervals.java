import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a collection of intervals, merge all overlapping intervals.
 */
public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		if(intervals.length<=1){
			return intervals;
		}
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		List<int[]> arr=new ArrayList<int[]>();
		int[] start=intervals[0];
		arr.add(start);
		for(int i=1; i<intervals.length;i++){
			if(intervals[i][0]<=start[1]){
				start[1]=Math.max(start[1],intervals[i][1]);
			}
			else{
				start = intervals[i];
				arr.add(intervals[i]);
			}
		}

		return arr.toArray(new int[arr.size()][]);
	}
}
