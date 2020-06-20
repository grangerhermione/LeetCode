package trees;
/*
 * https://leetcode.com/problems/inorder-successor-in-bst/
 * 
 * Inorder Successor in BST:
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * The successor of a node p is the node with the smallest key greater than p.val.
 */
public class InorderSuccessorInBST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode res = null;
		while(root!=null) {
			if(root.val > p.val) {
				res = root;
				root = root.left;
			}
			else root = root.right;
		}
		return res;
	}
}
