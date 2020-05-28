package strings;

import java.util.Stack;

/*
 * https://leetcode.com/problems/simplify-path/	
 * Simplify Path:
 * Given an absolute path for a file (Unix-style), simplify it. 
 * Or in other words, convert it to the canonical path.
 */
public class SimplifyPath {
	public String simplifyPath(String path) {
		if(path.isEmpty()){
			return path;
		}
		Stack<String> stack=new Stack<>();
		String tokens[]=path.split("/");

		for(String val: tokens){
			if(val.equals(".") || val.isEmpty()){
				continue;
			}
			else if(val.equals("..")){
				if(!stack.isEmpty()){
					stack.pop();
				}
			}
			else{
				stack.push(val);
			}
		}
		StringBuilder sb=new StringBuilder();
		for(String s:stack){
			sb.append("/"+s);
		}
		return sb.length()>0 ?sb.toString() : "/";
	}
}
