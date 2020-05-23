package trees;
/*
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 * Maximum Difference Between Node and Ancestor:
 * Given the root of a binary tree, find the maximum value V for which there exists different 
 * nodes A and B where V = |A.val - B.val| and A is an ancestor of B.
 * (A node A is an ancestor of B if either: any child of A is equal to B, or any child of A 
 * is an ancestor of B.)
 */
public class MaximumDifferenceBetweenNodeAndAncestor {
	public int maxAncestorDiff(TreeNode root) {
		return dfs(root, root.val, root.val);
	}

	private int dfs(TreeNode root, int min, int max){
		if(root==null){
			return 0;
		}
		int diff = Math.max(max-root.val, root.val-min);
		min=Math.min(min, root.val);
		max=Math.max(max, root.val);

		return Math.max(Math.max(diff, dfs(root.left, min, max)), dfs(root.right, min, max));

	}
}
