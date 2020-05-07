package linkedlists;
/*
 * https://leetcode.com/problems/reorder-list/
 * Reorder list:
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 */

public class ReorderList {
	public void reorderList(ListNode head) {
		if(head==null || head.next==null){
			return;
		}

		ListNode fast=head;
		ListNode slow=head;
		while(fast.next!=null && fast.next.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}

		//Slow is at the start of second half
		//Reverse the second half

		ListNode p=slow.next;
		ListNode first=p;
		slow.next=null;
		ListNode q=p.next;
		while(q!=null){
			ListNode temp=q.next;
			q.next=p;
			p=q;
			q=temp;
		}
		first.next=null;

		ListNode nexthead=p;

		//merge both lists with head and nexthead

		p=head;
		q=nexthead;
		while(p!=null && q!=null){
			ListNode tempP=p.next;
			ListNode tempQ=q.next;
			p.next=q;
			q.next=tempP;
			q=tempQ;
			p=tempP;
		}

	}
}
