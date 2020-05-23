package linkedlists;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Merge k Sorted Lists:
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> pq=new PriorityQueue<>(new Comparator<ListNode>(){
			@Override
			public int compare(ListNode a, ListNode b){
				return a.val-b.val;
			}
		});

		for(ListNode h:lists){
			if(h!=null){
				pq.offer(h);
			}
		}

		ListNode head=new ListNode(0);
		ListNode curr=head;
		while(!pq.isEmpty()){
			ListNode top=pq.poll();
			curr.next=top;
			curr=curr.next;
			if(curr.next!=null){
				pq.add(curr.next);
			}
		}
		return head.next;
	}
}
