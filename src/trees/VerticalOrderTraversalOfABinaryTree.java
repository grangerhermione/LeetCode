package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 * Vertical Order Traversal of a Binary Tree:
 * Given a binary tree, return the vertical order traversal of its nodes values.
 * For each node at position (X, Y), its left and right children respectively will be at 
 * positions (X-1, Y-1) and (X+1, Y-1).
 * Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line 
 * touches some nodes, we report the values of the nodes in order from top to bottom 
 * (decreasing Y coordinates).
 * If two nodes have the same position, then the value of the node that is reported first is the 
 * value that is smaller.
 * Return an list of non-empty reports in order of X coordinate. 
 * Every report will have a list of values of nodes.
 */
public class VerticalOrderTraversalOfABinaryTree {
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> result=new ArrayList<>();
		if(root==null){
			return result;
		}
		int maxCol=0,minCol=0;

		Queue<TreeNode> q=new LinkedList<>();
		Queue<int[]> cols=new LinkedList<>();
		Map<Integer, List<List<Integer>>> map=new HashMap<>();
		q.add(root);
		cols.add(new int[] {0,0});
		while(!q.isEmpty()){
			TreeNode node=q.poll();
			int[] col=cols.poll();

			if(node!=null){
				if(!map.containsKey(col[1])){
					map.put(col[1], new ArrayList<>());
				}
				map.get(col[1]).add(new ArrayList<>(Arrays.asList(col[0], node.val)));
				minCol=Math.min(minCol, col[1]);
				maxCol=Math.max(maxCol, col[1]);
				q.add(node.left);
				cols.add(new int[]{col[0]+1,col[1]-1});
				q.add(node.right);
				cols.add(new int[]{col[0]+1,col[1]+1});
			}
		}

		
		for(int i=minCol;i<=maxCol;i++){
			List<List<Integer>> values = map.get(i);
			Collections.sort(values, new Comparator<List<Integer>>(){
				@Override
				public int compare(List<Integer> a, List<Integer> b) {
					if(a.get(0)==b.get(0)) {
						return a.get(1)-b.get(1);
					}
					return a.get(0)-b.get(0);
				}
			});
			List<Integer> sortedColumn = new ArrayList<>();
            for (List<Integer> p : values) {
                sortedColumn.add(p.get(1));
            }
			result.add(sortedColumn);
		}

		return result;
	}
}
