package trees;
/*
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 * 
 * Closest Binary Search Tree Value:
 * Given a non-empty binary search tree and a target value, 
 * find the value in the BST that is closest to the target.
 */
public class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
		int prev=root.val;
		int curr=root.val;
		while(root!=null){
			curr=root.val;
			if(Math.abs(curr-target)<Math.abs(prev-target)){
				prev=curr;
			}
			if(target<curr){
				root=root.left;
			}
			else{
				root=root.right;
			}
		}
		return prev;
	}
}
