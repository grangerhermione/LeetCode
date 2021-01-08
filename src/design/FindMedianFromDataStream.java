package design;

import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/find-median-from-data-stream/
 * 
 * Find Median from Data Stream:
 * Median is the middle value in an ordered integer list. If the size of the list is even, 
 * there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.

 */
public class FindMedianFromDataStream {
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;
	/** initialize your data structure here. */
	public FindMedianFromDataStream() {
		minHeap=new PriorityQueue<>();
		maxHeap=new PriorityQueue<>((a,b)->b-a);
	}

	public void addNum(int num) {
		maxHeap.add(num);
		minHeap.add(maxHeap.poll());
		if(maxHeap.size()<minHeap.size()){
			maxHeap.add(minHeap.poll());
		}
	}

	public double findMedian() {
		if(maxHeap.size()==0){
			return 0;
		}
		if(maxHeap.size()>minHeap.size()){
			return maxHeap.peek();
		}
		return (maxHeap.peek()+minHeap.peek())/2.0;
	}
}
