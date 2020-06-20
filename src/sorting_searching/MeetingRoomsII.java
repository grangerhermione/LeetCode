package sorting_searching;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/meeting-rooms-ii/
 * 
 * Meeting Rooms II:
 * Given an array of meeting time intervals consisting of start and end times 
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 */
public class MeetingRoomsII {
	public int minMeetingRooms(int[][] intervals) {
		if(intervals.length==0){
			return 0;
		}
		Arrays.sort(intervals, (x, y)->(x[0]==y[0]?x[1]-y[1]:x[0]-y[0]));
		PriorityQueue<Integer> pq=new PriorityQueue<>();

		pq.add(intervals[0][1]);
		for(int i=1;i<intervals.length;i++){
			if(intervals[i][0]>=pq.peek()){
				pq.poll();
			}
			pq.add(intervals[i][1]);
		}
		return pq.size();
	}
}
