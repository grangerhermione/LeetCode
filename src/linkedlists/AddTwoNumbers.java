package linkedlists;
/* 
 * https://leetcode.com/problems/add-two-numbers/
 * Add Two Numbers: 
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode h1=l1;
		ListNode h2=l2;
		ListNode head=null;
		ListNode result=null;
		int carry=0;
		while(h1!=null && h2!=null){
			int sum=h1.val+h2.val+carry;
			carry=sum/10;
			int rem=sum%10;
			ListNode curr=new ListNode(rem);
			if(head==null){
				head=curr;
				result=head;
			}
			else{
				head.next=curr;
				head=head.next;
			}
			h1=h1.next;
			h2=h2.next;
		}
		while(h1!=null){
			int sum=h1.val+carry;
			carry=sum/10;
			int rem=sum%10;
			ListNode curr=new ListNode(rem);
			if(head==null){
				head=curr;
				result=head;
			}
			else{
				head.next=curr;
				head=head.next;
			}
			h1=h1.next;
		}
		while(h2!=null){
			int sum=h2.val+carry;
			carry=sum/10;
			int rem=sum%10;
			ListNode curr=new ListNode(rem);
			if(head==null){
				head=curr;
				result=head;
			}
			else{
				head.next=curr;
				head=head.next;
			}
			h2=h2.next;
		}
		if(carry==0){
			head.next=null;
			return result;
		}

		ListNode curr=new ListNode(carry);
		head.next=curr;
		head=curr;
		head.next=null;

		return result;

	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
