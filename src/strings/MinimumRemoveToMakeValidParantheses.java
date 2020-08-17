package strings;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * Minimum Remove to Make Valid Parentheses:
 * Given a string s of '(' , ')' and lowercase English characters. 

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) 
so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 */
public class MinimumRemoveToMakeValidParantheses {
	public String minRemoveToMakeValid(String s) {
		Set<Integer> remove=new HashSet<>();
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);

			if(c=='('){
				stack.push(i);
			}
			else if(c==')'){
				if(stack.isEmpty()){
					remove.add(i);
				}
				else{
					stack.pop();
				}
			}
		}
		while(!stack.isEmpty()){
			remove.add(stack.pop());
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length();i++){
			if(!remove.contains(i)){
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
	
	/*
	 *  private StringBuilder removeInvalidClosing(CharSequence string, char open, char close) {
	        StringBuilder sb = new StringBuilder();
	        int balance = 0;
	        for (int i = 0; i < string.length(); i++) {
	            char c = string.charAt(i);
	            if (c == open) {
	                balance++;
	            } if (c == close) {
	                if (balance == 0) continue;
	                balance--;
	            }
	            sb.append(c);
	        }  
	        return sb;
	    }
	
	    public String minRemoveToMakeValid(String s) {
	        StringBuilder result = removeInvalidClosing(s, '(', ')');
	        result = removeInvalidClosing(result.reverse(), ')', '(');
	        return result.reverse().toString();
	    }
	 * 
	 */
	
	/*
	 * public String minRemoveToMakeValid(String s) {

	        // Parse 1: Remove all invalid ")"
	        StringBuilder sb = new StringBuilder();
	        int openSeen = 0;
	        int balance = 0;
	        for (int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);
	            if (c == '(') {
	                openSeen++;
	                balance++;
	            } if (c == ')') {
	                if (balance == 0) continue;
	                balance--;
	            }
	            sb.append(c);
	        }
	
	        // Parse 2: Remove the rightmost "("
	        StringBuilder result = new StringBuilder();
	        int openToKeep = openSeen - balance;
	        for (int i = 0; i < sb.length(); i++) {
	            char c = sb.charAt(i);
	            if (c == '(') {
	                openToKeep--;
	                if (openToKeep < 0) continue;
	            }
	            result.append(c);
	        }
	
	        return result.toString();
	    }
	 */
}
