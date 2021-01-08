package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * Valid Parentheses:
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 */
public class ValidParantheses {
	public boolean isValid(String s) {
		Stack<Character> stack=new Stack<>();
		Map<Character, Character> match=new HashMap<>();

		match.put(')','(');
		match.put('}','{');
		match.put(']','[');

		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(ch=='(' || ch=='{' || ch=='['){
				stack.push(ch);
			}
			else{
				if(stack.isEmpty()){
					return false;
				}
				if(stack.peek()!=match.get(ch)){
					return false;
				}
				stack.pop();
			}
		}
		if(!stack.isEmpty()){
			return false;
		}
		return true;
	}
}
