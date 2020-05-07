package dynamic_programming;
/*
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * Longest Palindromic Substring:
 * Given a string s, find the longest palindromic substring in s. 
 * You may assume that the maximum length of s is 1000.
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if(s==null||s.length()<1){
			return s;
		}
		if(s.length()==1){
			return s;
		}
		String longest=s.substring(0,1);
		for(int i=0;i<s.length();i++){
			String pal1=palindrome(s,i,i);
			if(pal1.length()>longest.length()){
				longest=pal1;
			}
			String pal2=palindrome(s,i,i+1);
			if(pal2.length()>longest.length()){
				longest=pal2;
			}
		}
		return longest;
	}

	private String palindrome(String s, int begin, int end){
		while(begin>=0 && end<s.length() && s.charAt(begin)==s.charAt(end)){
			begin--;
			end++;
		}
		return s.substring(begin+1,end);
	}
}
