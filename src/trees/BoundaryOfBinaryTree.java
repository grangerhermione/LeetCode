package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * https://leetcode.com/problems/boundary-of-binary-tree/
 * 
 * Boundary of Binary Tree:
 * Given a binary tree, return the values of its boundary in anti-clockwise direction 
 * starting from root. Boundary includes left boundary, leaves, and right boundary in order 
 * without duplicate nodes.  (The values of the nodes may still be duplicates.)

Left boundary is defined as the path from root to the left-most node. Right boundary is defined 
as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, 
then the root itself is left boundary or right boundary. Note this definition only applies to the 
input binary tree, and not applies to any subtrees.

The left-most node is defined as a leaf node you could reach when you always firstly travel to the 
left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

The right-most node is also defined by the same way with left and right exchanged.
 */
public class BoundaryOfBinaryTree {
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		if (!isLeaf(root)) {
			res.add(root.val);
		}
		TreeNode t = root.left;
		while (t != null) {
			if (!isLeaf(t)) {
				res.add(t.val);
			}
			if (t.left != null) {
				t = t.left;
			} else {
				t = t.right;
			}

		}
		addLeaves(res, root);

		Stack<Integer> s = new Stack<>();
		t = root.right;
		while (t != null) {
			if (!isLeaf(t)) {
				s.push(t.val);
			}
			if (t.right != null) {
				t = t.right;
			} else {
				t = t.left;
			}
		}
		while (!s.empty()) {
			res.add(s.pop());
		}
		return res;
	}

	public boolean isLeaf(TreeNode t) {
		return t.left == null && t.right == null;
	}

	public void addLeaves(List<Integer> res, TreeNode root) {
		if (isLeaf(root)) {
			res.add(root.val);
		} else {
			if (root.left != null) {
				addLeaves(res, root.left);
			}
			if (root.right != null) {
				addLeaves(res, root.right);
			}
		}
	}
}
