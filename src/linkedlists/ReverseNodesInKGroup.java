package linkedlists;
/*
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. 
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 */
public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode p=head;
		ListNode tail=null;
		ListNode newHead=null;
		while(p!=null){
			int count=0;
			p=head;
			while(count<k && p!=null){
				p=p.next;
				count++;
			}
			if(count==k){
				ListNode prev=reverse(head, k);
				if(newHead==null){
					newHead=prev;
				}
				if(tail!=null){
					tail.next=prev;
				}
				tail=head;
				head=p;
			}
		}
		if(tail!=null){
			tail.next=head;
		}
		if(newHead==null){
			return head;
		}
		return newHead;
	}

	private ListNode reverse(ListNode head, int k){
		ListNode prev=null;
		ListNode p=head;
		while(k>0){
			ListNode next=p.next;
			p.next=prev;
			prev=p;
			p=next;
			k--;
		}
		return prev;
	}
}
