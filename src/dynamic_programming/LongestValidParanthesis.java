package dynamic_programming;
/*
 * https://leetcode.com/problems/longest-valid-parentheses/
 * 
 * Longest Valid Parentheses:
 * Given a string containing just the characters '(' and ')', find the 
 * length of the longest valid (well-formed) parentheses substring.
 */
public class LongestValidParanthesis {
	public int longestValidParentheses(String s) {
		int left=0,right=0;
		int max=0;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(ch=='('){
				left++;
			}
			else{
				right++;
			}
			if(left==right){
				max=Math.max(max, 2*right);
			}
			else if(right>=left){
				left=0;
				right=0;
			}
		}
		left=0;
		right=0;
		for(int i=s.length()-1;i>=0;i--){
			char ch=s.charAt(i);
			if(ch=='('){
				left++;
			}
			else{
				right++;
			}
			if(left==right){
				max=Math.max(max, 2*right);
			}
			else if(left>=right){
				left=0;
				right=0;
			}
		}
		return max;
	}
	
	/*
	 public int longestValidParentheses(String s) {
	        Stack<Integer> stack=new Stack<>();
	        stack.push(-1);
	        int res=0;
	        for(int i=0;i<s.length();i++){
	            if(s.charAt(i)=='('){
	                stack.push(i);
	            }
	            else{
	                stack.pop();
	                if(!stack.isEmpty()){
	                    res=Math.max(res, i-stack.peek());
	                }
	                else{
	                    stack.push(i);
	                }
	            }
	        }
	        return res;
	    }
	    */
}
