package design;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/design-hit-counter/
 * 
 * Design Hit Counter:
 * Design a hit counter which counts the number of hits received in the past 5 minutes.

Each function accepts a timestamp parameter (in seconds granularity) and you may assume 
that calls are being made to the system in chronological order (ie, the timestamp is monotonically 
increasing). You may assume that the earliest timestamp starts at 1.

It is possible that several hits arrive roughly at the same time.
 */
public class DesignHitCounter {
	Queue<Integer> q;
	/** Initialize your data structure here. */
	public DesignHitCounter() {
		q=new LinkedList<>();
	}

	/** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
	public void hit(int timestamp) {
		q.offer(timestamp);
	}

	/** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
	public int getHits(int timestamp) {
		while(!q.isEmpty() && timestamp - q.peek() >= 300) {
			q.poll();
		}
		return q.size();
	}
}
