package recursion_backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * Remove Invalid Parentheses:
 * Remove the minimum number of invalid parentheses in order to make the input string valid. 
 * Return all possible results.
 */
public class RemoveInvalidParantheses {
	Set<String> set=new HashSet<>();
	public List<String> removeInvalidParentheses(String s) {
		int left=0;
		int right=0;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(ch=='('){
				left++;
			}
			else if(ch==')'){
				if(left==0){
					right++;
				}
				if(left>0){
					left--;
				}
			}
		}

		recurse(s, 0, 0, 0, left, right, new StringBuilder());

		return new ArrayList<String>(set);
	}

	private void recurse(String s, int index, int left, int right, int leftCount, int rightCount, StringBuilder sb){
		if(index==s.length()){
			if(leftCount==0 && rightCount==0){
				set.add(sb.toString());
			}
		}
		else{
			char ch=s.charAt(index);
			if(ch=='(' && leftCount>0){
				recurse(s, index+1, left, right, leftCount-1, rightCount, sb);
			}
			else if(ch==')' && rightCount>0){
				recurse(s, index+1, left, right, leftCount, rightCount-1, sb);
			}

			sb.append(ch);
			if(ch!='(' && ch!=')'){
				recurse(s, index+1, left, right, leftCount, rightCount, sb);
			}
			else if(ch=='('){
				recurse(s, index+1, left+1, right, leftCount, rightCount, sb);
			}
			else if(right<left){
				recurse(s, index+1, left, right+1, leftCount, rightCount, sb);
			}
			sb.deleteCharAt(sb.length()-1);
		}
	}
}
