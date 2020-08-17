package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 * Binary Tree Vertical Order Traversal:
 * Given a binary tree, return the vertical order traversal of its nodes' values. 
 * (ie, from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 */
public class BinaryTreeVerticalOrderTraversal {
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result=new ArrayList<>();
		if(root==null){
			return result;
		}

		Queue<TreeNode> q=new LinkedList<>();
		Queue<Integer> cols=new LinkedList<>();
		Map<Integer, List<Integer>> map=new HashMap<>();

		int minColumn=0;
        int maxColumn=0;
        
		q.add(root);
		cols.add(0);
		while(!q.isEmpty()){
			TreeNode node=q.poll();
			int col=cols.poll();

			if(node!=null){
				if(!map.containsKey(col)){
					map.put(col, new ArrayList<Integer>());
				}
				map.get(col).add(node.val);
				minColumn=Math.min(minColumn, col);
                maxColumn=Math.max(maxColumn, col);
				q.add(node.left);
				cols.add(col-1);
				q.add(node.right);
				cols.add(col+1);
			}
		}
		
		for(int i=minColumn;i<=maxColumn;i++){
            result.add(map.get(i));
        }

		return result;
	}
}
