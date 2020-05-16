package trees;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/binary-tree-paths/
 * Binary Tree Paths:
 * Given a binary tree, return all root-to-leaf paths.
 */
public class BinaryTreePaths {
	List<String> result;
	public List<String> binaryTreePaths(TreeNode root) {
		result=new ArrayList<>();
		constructPath(root, "");
		return result;
	}

	private void constructPath(TreeNode root, String str){
		if(root!=null){
			str+=(root.val);
			if(root.left==null && root.right==null){
				result.add(str);
			}
			else{
				str+="->";
				constructPath(root.left, str);
				constructPath(root.right, str);
			}
		}
	}
}
