package dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/word-break-ii/
 * Word Break II:
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word. 
 * Return all such possible sentences.
 */
public class WordBreakII {
	public List<String> wordBreak(String s, List<String> wordDict) {
		Set<String> dict=new HashSet<>(wordDict);

		boolean[] dp1 = new boolean[s.length() + 1];
		dp1[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp1[j] && dict.contains(s.substring(j, i))) {
					dp1[i] = true;
					break;
				}
			}
		}

		if (!dp1[s.length()]) {
			return new ArrayList<String>();
		}

		List<String> dp[]=new ArrayList[s.length()+1];
		List<String> first=new ArrayList<>();
		first.add("");
		dp[0]=first;



		for(int i=1;i<=s.length();i++){
			List<String> temp=new ArrayList<>();

			for(int j=0;j<i;j++){
				if(dp[j].size()>0 && dict.contains(s.substring(j,i))){
					for(String t: dp[j]){
						temp.add(t+(t.equals("")?"":" ")+s.substring(j,i));
					}
				}
			}
			dp[i]=temp;
		}
		return dp[s.length()];
	}
}
