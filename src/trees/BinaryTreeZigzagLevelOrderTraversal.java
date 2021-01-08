package trees;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 
 * Binary Tree Zigzag Level Order Traversal:
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res=new ArrayList<>();
		if(root==null){
			return res;
		}
		dfs(root, 0, res);
		return res;
	}

	private void dfs(TreeNode root, int level, List<List<Integer>> res){
		if(root==null){
			return;
		}
		if(level==res.size()){
			List<Integer> temp=new ArrayList<>();
			res.add(temp);
		}
		if(level%2==0){
			res.get(level).add(root.val);
		}
		else{
			res.get(level).add(0, root.val);
		}
		dfs(root.left, level+1, res);
		dfs(root.right, level+1, res);

	}
	//BFS
	//	     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	//	         List<List<Integer>> res=new ArrayList<>();
	//	         if(root==null){
	//	             return res;
	//	         }

	//	         Queue<TreeNode> q=new LinkedList<>();
	//	         q.add(root);
	//	         boolean isLeft=true;
	//	         while(!q.isEmpty()){ 
	//	             int num=q.size();
	//	             LinkedList<Integer> levels=new LinkedList<>();

	//	             for(int i=0;i<num;i++){
	//	                 TreeNode n=q.poll();
	//	                 if(isLeft){
	//	                     levels.addLast(n.val);
	//	                 }
	//	                 else{
	//	                     levels.addFirst(n.val);
	//	                 }
	//	                 if(n.left!=null){
	//	                     q.add(n.left);
	//	                 }
	//	                 if(n.right!=null){
	//	                     q.add(n.right);
	//	                 }
	//	             }
	//	             res.add(levels);
	//	             isLeft=!isLeft;
	//	         }
	//	         return res;
	//	     }
}
