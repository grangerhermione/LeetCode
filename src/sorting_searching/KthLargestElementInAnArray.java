package sorting_searching;

import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 
 * Kth Largest Element in an Array:
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in 
 * the sorted order, not the kth distinct element.
 */
public class KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        
        for(int i=0;i<nums.length;i++){
            queue.offer(nums[i]);
            if(queue.size()>k){
                queue.poll();
            }
        }
        
        return queue.poll();
    }
}
