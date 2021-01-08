package trees;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 * Binary Tree Level Order Traversal:
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {
	//DFS
	public List<List<Integer>> levelOrder(TreeNode root) {
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
		res.get(level).add(root.val);
		dfs(root.left, level+1, res);
		dfs(root.right, level+1, res);

	}
	//BFS
	//     public List<List<Integer>> levelOrder(TreeNode root) {
	//         List<List<Integer>> res=new ArrayList<>();
	//         if(root==null){
	//             return res;
	//         }
	//         Queue<TreeNode> q=new LinkedList<>();
	//         q.add(root);
	//         int level=0;
	//         while(!q.isEmpty()){ 
	//             int num=q.size();
	//             List<Integer> levels=new ArrayList<>();

	//             for(int i=0;i<num;i++){
	//                 TreeNode n=q.poll();
	//                 levels.add(n.val);
	//                 if(n.left!=null){
	//                     q.add(n.left);
	//                 }
	//                 if(n.right!=null){
	//                     q.add(n.right);
	//                 }
	//             }
	//             
	//             res.add(levels);
	//         }
	//         return res;
	//     }
}
