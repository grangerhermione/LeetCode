package design;

import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * Serialize and Deserialize Binary Tree:
 * Serialization is the process of converting a data structure or object into a 
 * sequence of bits so that it can be stored in a file or memory buffer, or 
 * transmitted across a network connection link to be reconstructed later in the same or 
 * another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree. 
 * There is no restriction on how your serialization/deserialization algorithm should work. 
 * You just need to ensure that a binary tree can be serialized to a string and this 
 * string can be deserialized to the original tree structure.
 */
public class SerializeAndDeSerializeBinaryTree {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		return preorder(root, "");
	}

	private String preorder(TreeNode root, String s){
		if(root==null){
			s+="null,";
		}
		else{
			s+= String.valueOf(root.val)+",";
			s = preorder(root.left, s);
			s = preorder(root.right, s);
		}
		return s;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String tokens[]=data.split(",");
		List<String> list=new LinkedList<>();
		for(String token:tokens){
			if(!token.equals("")){
				list.add(token);
			}
		}

		return buildTree(list);
	}

	private TreeNode buildTree(List<String> list){
		if(list.get(0).equals("null")){
			list.remove(0);
			return null;
		}
		TreeNode root=new TreeNode(Integer.valueOf(list.get(0)));
		list.remove(0);
		root.left=buildTree(list);
		root.right=buildTree(list);

		return root;
	}
}
