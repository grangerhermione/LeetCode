package trees;
/*
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Lowest Common Ancestor of a Binary Tree:
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: 
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T 
 * that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return lca(root,p,q);
	}

	private TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
		if(root==null){
			return null;
		}
		if(root==p || root==q){
			return root;
		}

		TreeNode left=lca(root.left, p, q);
		TreeNode right=lca(root.right, p, q);

		if(left!=null && right!=null){
			return root;
		}
		if(left==null && right == null){
			return null;
		}
		return left==null?right:left;
	}
}
