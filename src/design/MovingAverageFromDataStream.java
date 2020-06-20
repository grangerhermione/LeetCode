package design;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/moving-average-from-data-stream/
 * 
 * Moving Average from Data Stream:
 * Given a stream of integers and a window size, calculate the moving average of all integers 
 * in the sliding window.
 */
public class MovingAverageFromDataStream {
	Queue<Integer> q;
	int sum;
	int len;
	/** Initialize your data structure here. */
	public MovingAverageFromDataStream(int size) {
		len=size;
		sum=0;
		q=new LinkedList<>();
	}

	public double next(int val) {
		sum+=val;
		q.add(val);
		if(q.size()>len){
			sum-=q.poll();
		}
		return sum/(1.0*q.size());
	}
}
