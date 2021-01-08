package trees;
/*
 * https://leetcode.com/problems/symmetric-tree/
 * 
 * Symmetric Tree:
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left,root.right);
    }
    
    private boolean isMirror(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null){
            return false;
        }
        return(left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left));
    }
}
