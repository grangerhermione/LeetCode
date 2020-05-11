package dynamic_programming;
/*
 * https://leetcode.com/problems/decode-ways/
 * 
 * Decode Ways:
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 *  ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 */
public class DecodeWays {
	public int numDecodings(String s) {
		if(s.charAt(0)=='0'){
			return 0;
		}
		int n=s.length();
		int dp[]=new int[n+1];
		dp[0]=1;
		dp[1]=1;
		for(int i=1;i<n;i++){
			int curr=s.charAt(i);
			int prev=s.charAt(i-1);
			if(curr=='0' && (prev=='0' || prev>'2')){
				return 0;
			}
			if(prev=='1'){
				if(curr=='0'){
					dp[i+1]=dp[i-1];
				}
				else{
					dp[i+1]=dp[i-1]+dp[i];
				}
			}
			else if(prev=='2'){
				if(curr=='0'){
					dp[i+1]=dp[i-1];
				}
				else if(curr<='6'){
					dp[i+1]=dp[i-1]+dp[i];
				}
				else{
					dp[i+1]=dp[i];
				}
			}
			else{
				dp[i+1]=dp[i];   
			}
		}
		return dp[n];
	}
}
