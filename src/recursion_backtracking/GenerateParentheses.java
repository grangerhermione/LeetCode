package recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/generate-parentheses/
 * 
 * Generate Parentheses:
 * Given n pairs of parentheses, write a function to generate all combinations of 
 * well-formed parentheses.
 */
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> result=new ArrayList<>();
		dfs(result,"",n,n);
		return result;
	}

	private void dfs(List<String> result, String sb, int left, int right){
		if(left>right){
			return;
		}
		if(left==0 && right==0){
			result.add(sb);
			return;
		}
		if(left>0){
			dfs(result, sb+"(", left-1, right);
		}
		if(right>0){
			dfs(result, sb+")", left, right-1);
		}
	}
}
