package linkedlists;
/*
 * https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
 * 
 * Insert into a Sorted Circular Linked List:
 * Given a node from a Circular Linked List which is sorted in ascending order, 
 * write a function to insert a value insertVal into the list such that it remains a sorted 
 * circular list. The given node can be a reference to any single node in the list, and may not 
 * be necessarily the smallest value in the circular list.
 * If there are multiple suitable places for insertion, you may choose any place to insert 
 * the new value. After the insertion, the circular list should remain sorted.
 * If the list is empty (i.e., given node is null), you should create a new single circular list 
 * and return the reference to that single node. Otherwise, you should return the original given node.
 */
public class InsertIntoASortedCircularLinkedList {
	public Node insert(Node head, int insertVal) {
		if (head == null) {
			Node newNode = new Node(insertVal, null);
			newNode.next = newNode;
			return newNode;
		}

		Node prev = head;
		Node curr = head.next;
		boolean toInsert = false;

		do {
			if (prev.val <= insertVal && insertVal <= curr.val) {
				toInsert = true;
			} else if (prev.val > curr.val) {
				if (insertVal >= prev.val || insertVal <= curr.val)
					toInsert = true;
			}

			if (toInsert) {
				prev.next = new Node(insertVal, curr);
				return head;
			}

			prev = curr;
			curr = curr.next;
		} while (prev != head);

		prev.next = new Node(insertVal, curr);
		return head;
	}


	class Node {
		public int val;
		public Node next;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _next) {
			val = _val;
			next = _next;
		}
	};
}

