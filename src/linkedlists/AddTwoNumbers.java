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
        ListNode head=new ListNode(0);
        ListNode curr=head;
        ListNode p1=l1;
        ListNode p2=l2;
        int carry = 0;
        while(p1!=null || p2!=null){
            if(p1!=null){
                carry+=p1.val;
                p1=p1.next;
            }
            if(p2!=null){
                carry+=p2.val;
                p2=p2.next;
            }
            ListNode temp=new ListNode(carry%10);
            carry=carry/10;
            curr.next=temp;
            curr=curr.next;
        }
        if(carry!=0){
            ListNode temp=new ListNode(carry);
            curr.next=temp;
            curr=curr.next;
        }
        return head.next;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
