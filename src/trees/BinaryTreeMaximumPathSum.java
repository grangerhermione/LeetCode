package trees;
/*
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * Binary Tree Maximum Path Sum:
 * 
 * Given a non-empty binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to 
 * any node in the tree along the parent-child connections. 
 * The path must contain at least one node and does not need to go through the root.
 */
public class BinaryTreeMaximumPathSum {
	int result;
	public int maxPathSum(TreeNode root) {
		result=Integer.MIN_VALUE;
		sum(root);
		return result;
	}

	private int sum(TreeNode root){
		if(root==null){
			return 0;
		}
		int left=Math.max(sum(root.left),0);
		int right=Math.max(sum(root.right),0);
		int curr=Math.max(root.val, root.val+Math.max(left,right));
		if(root.val+left+right>result){
			result=root.val+left+right;
		}
		return curr;

	}
}
