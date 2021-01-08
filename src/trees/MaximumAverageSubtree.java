package trees;
/*
 * https://leetcode.com/problems/maximum-average-subtree/
 * 
 * Maximum Average Subtree:
 * Given the root of a binary tree, find the maximum average value of any subtree of that tree.

(A subtree of a tree is any node of that tree plus all its descendants. 
The average value of a tree is the sum of its values, divided by the number of nodes.)

 */
public class MaximumAverageSubtree {
	double max=Double.MIN_VALUE;
	public double maximumAverageSubtree(TreeNode root) {
		dfs(root);
		return max;
	}

	private int[] dfs(TreeNode root){
		if(root==null){
			return new int[]{0, 0};
		}
		int left[]=dfs(root.left);
		int right[]=dfs(root.right);
		int count=left[1]+right[1]+1;
		int sum=left[0]+right[0]+root.val;

		double average=1.0*sum/count;
		max=Math.max(max,average);
		return new int[]{sum, count};
	}
}
