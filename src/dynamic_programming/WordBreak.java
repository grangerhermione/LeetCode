package dynamic_programming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/word-break/
 * Word Break:
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 */
public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> set=new HashSet<>(wordDict);
		boolean dp[]=new boolean[s.length()+1];
		dp[0]=true;
		for(int i=1;i<=s.length();i++){
			for(int j=0;j<i;j++){
				if(dp[j] && set.contains(s.substring(j,i))){
					dp[i]=true;
					break;
				}
			}
		}
		return dp[s.length()];

	}
}
