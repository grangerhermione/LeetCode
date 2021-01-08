package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 * 
 * All Nodes Distance K in Binary Tree:
 * We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  
The answer can be returned in any order.


 */
public class AllNodesDistanceKInBinaryTree {
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		Map<TreeNode, TreeNode> map=new HashMap<>();
		dfs(root, root, map);

		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(target);

		Set<TreeNode> set=new HashSet<>();
		set.add(target);

		int dist=0;
		while(!queue.isEmpty() && dist<K){
			int size=queue.size();
			dist++;
			for(int i=0;i<size;i++){
				TreeNode curr=queue.poll();
				if(curr.left!=null && !set.contains(curr.left)){
					queue.add(curr.left);
					set.add(curr.left);
				}
				if(curr.right!=null && !set.contains(curr.right)){
					queue.add(curr.right);
					set.add(curr.right);
				}
				TreeNode parent=map.get(curr);
				if(!set.contains(parent)){
					queue.add(parent);
					set.add(parent);
				}
			}
		}
		List<Integer> result=new ArrayList<>();
		while(!queue.isEmpty()){
			result.add(queue.poll().val);
		}
		return result;
	}

	private void dfs(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> map){
		if(node!=null){
			map.put(node, parent);
			dfs(node.left, node, map);
			dfs(node.right, node, map);
		}
	}
}
