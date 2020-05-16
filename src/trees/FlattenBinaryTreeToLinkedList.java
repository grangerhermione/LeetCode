package trees;
/*
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * Flatten Binary Tree to Linked List:
 * Given a binary tree, flatten it to a linked list in-place.
 */

public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		flattenTree(root);
	}

	private TreeNode flattenTree(TreeNode root){
		if(root==null){
			return null;
		}
		if(root.left==null && root.right==null){
			return root;
		}

		TreeNode left=flattenTree(root.left);
		TreeNode right=flattenTree(root.right);

		if(left!=null){
			left.right=root.right;
			root.right=root.left;
			root.left=null;
		}

		if(right==null){
			return left;
		}
		return right;
	}
}
