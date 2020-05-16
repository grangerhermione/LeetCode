package design;

import java.util.Stack;

/*
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * Binary Search Tree Iterator:
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized 
 * with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 */
public class BinarySearchTreeIterator {
	Stack<TreeNode> stack;

	public BinarySearchTreeIterator(TreeNode root) {
		stack=new Stack<>();
		pushLeft(root);
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode top=stack.pop();
		if(top.right!=null){
			pushLeft(top.right);
		}
		return top.val;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	private void pushLeft(TreeNode root){
		while(root!=null){
			stack.push(root);
			root=root.left;
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
