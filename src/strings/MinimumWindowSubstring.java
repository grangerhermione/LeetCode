package strings;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/minimum-window-substring/
 * Minimum Window Substring:
 * Given a string S and a string T, find the minimum window in S which will contain all the 
 * characters in T in complexity O(n).
 */
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if(s.length()==0 || t.length()==0){
			return "";
		}

		Map<Character, Integer> tMap=new HashMap<>();
		for(Character ch: t.toCharArray()){
			tMap.put(ch, tMap.getOrDefault(ch,0)+1);
		}

		int len=tMap.size();
		int l=0,r=0;

		int formed=0;
		Map<Character, Integer> sMap=new HashMap<>();
		int max=-1;
		int left=0;
		int right=0;

		while(r<s.length()){
			char ch=s.charAt(r);
			sMap.put(ch, sMap.getOrDefault(ch,0)+1);

			if(tMap.containsKey(ch) && sMap.get(ch).intValue()==tMap.get(ch).intValue()){
				formed++;
			}

			while(l<=r && formed==len){
				ch=s.charAt(l);

				if(max==-1 || max>r-l+1){
					max=r-l+1;
					left=l;
					right=r;
				}

				sMap.put(ch, sMap.get(ch)-1);
				if(tMap.containsKey(ch) && sMap.get(ch).intValue()<tMap.get(ch).intValue()){
					formed--;
				}

				l++;
			}
			r++;

		}

		return max==-1?"":s.substring(left, right+1);
	}

}
