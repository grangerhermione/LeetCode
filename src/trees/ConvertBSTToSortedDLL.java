package trees;
/*
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 * 
 * Convert Binary Search Tree to Sorted Doubly Linked List:
 * Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
 * You can think of the left and right pointers as synonymous to the predecessor and successor 
 * pointers in a doubly-linked list. For a circular doubly linked list, 
 * the predecessor of the first element is the last element, 
 * and the successor of the last element is the first element.
 */
public class ConvertBSTToSortedDLL {
	Node first=null;
	Node last = null;
	public Node treeToDoublyList(Node root) {
		if(root==null){
			return null;
		}
		inorder(root);
		last.right=first;
		first.left=last;
		return first;
	}

	private void inorder(Node root){
		if(root==null){
			return;
		}

		inorder(root.left);

		if(last!=null){
			last.right=root;
			root.left=last;
		}
		else{
			first=root;
		}

		last=root;

		inorder(root.right);
	}

	class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val,Node _left,Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}
	};
}


