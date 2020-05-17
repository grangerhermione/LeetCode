package strings;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * Longest Substring with At Most K Distinct Characters:
 * Given a string, find the length of the longest substring T that contains at most 
 * k distinct characters.
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if(s.length()==0 || k==0){
			return 0;
		}
		int max=1;
		int l=0,r=0;

		Map<Character, Integer> map=new LinkedHashMap<>();
		while(r<s.length()){
			char ch=s.charAt(r);
			if(map.containsKey(ch)){
				map.remove(ch);
			}
			map.put(ch,r);
			r++;
			if(map.size()==k+1){
				Map.Entry<Character, Integer> entry=map.entrySet().iterator().next();
				map.remove(entry.getKey());
				l=entry.getValue()+1;
			}
			max=Math.max(max, r-l);
		}
		return max;

	}
}
