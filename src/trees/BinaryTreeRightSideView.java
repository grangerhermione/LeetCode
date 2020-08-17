package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * Binary Tree Right Side View:
 * Given a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		 List<Integer> res=new ArrayList<>();
	        if(root==null){
	            return res;
	        }
	        
	        Queue<TreeNode> q=new LinkedList<>();
	        q.add(root);
	        while(!q.isEmpty()){
	            int n=q.size();
	            Integer last=null;
	            for(int i=0;i<n;i++){
	                TreeNode node=q.poll();
	                last=node.val;
	                if(node.left!=null){
	                    q.add(node.left);
	                }
	                if(node.right!=null){
	                    q.add(node.right);
	                }
	            }
	            res.add(last);
	        }
	        
	        return res;

	}
}
