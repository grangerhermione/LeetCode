package sorting_searching;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/meeting-rooms/
 * 
 * Meeting Rooms:
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] 
 * (si < ei), determine if a person could attend all meetings.
 */
public class MeetingRooms {
	public boolean canAttendMeetings(int[][] intervals) {
		Arrays.sort(intervals, (x, y)->(x[0]==y[0]?x[1]-y[1]:x[0]-y[0]));
		for(int i=0;i<intervals.length-1;i++){
			int curr[]=intervals[i];
			int next[]=intervals[i+1];
			if(curr[1]>next[0]){
				return false;
			}
		}
		return true;

	}
}
