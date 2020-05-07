package strings;
/*
 * https://leetcode.com/problems/one-edit-distance/
 * 
 * One Edit Distance:
 * Given two strings s and t, determine if they are both one edit distance apart.

Note: 

There are 3 possiblities to satisify one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t

 */

public class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
		int ns=s.length();
		int nt=t.length();
		if(ns>nt){
			return isOneEditDistance(t,s);
		}
		if(nt-ns>1){
			return false;
		}

		for(int i=0;i<ns;i++){
			if(s.charAt(i)!=t.charAt(i)){
				if(ns==nt){
					return s.substring(i+1).equals(t.substring(i+1));
				}
				else{
					return s.substring(i).equals(t.substring(i+1));
				}
			}
		}
		return (nt-ns==1)?true:false;
	}
}
