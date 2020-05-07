package trees;
/*
 * https://leetcode.com/problems/validate-binary-search-tree/
 * Validate Binary Search Tree:
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 */
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return isBST(root, null, null);
	}

	private boolean isBST(TreeNode root, Integer min, Integer max){
		if(root==null){
			return true;
		}
		if(min!=null && root.val<=min){
			return false;
		}
		if(max!=null && root.val>=max){
			return false;
		}

		return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);

	}

}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}