package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * Binary Tree Right Side View:
 * Given a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		Map<Integer, Integer> map=new HashMap<>();
		int maxDepth=-1;

		Queue<TreeNode> q=new LinkedList<>();
		Queue<Integer> depth=new LinkedList<>();

		q.add(root);
		depth.add(0);

		while(!q.isEmpty()){
			TreeNode node=q.poll();
			Integer d=depth.poll();
			if(node!=null){
				maxDepth=Math.max(maxDepth, d);

				map.put(d, node.val);

				q.add(node.left);
				q.add(node.right);
				depth.add(d+1);
				depth.add(d+1);
			}
		}

		List<Integer> result=new ArrayList<>();
		for(int i=0;i<=maxDepth;i++){
			result.add(map.get(i));
		}

		return result;

	}
}
