package strings;
import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Longest Substring Without Repeating Characters:
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int l=0,r=0;
        int res=0;
        while(l<s.length() && r<s.length()){
            char ch=s.charAt(r);
            if(set.contains(ch)){
                set.remove(s.charAt(l));
                l++;
            }
            else{
                set.add(ch);
                r++;
                res=Math.max(res, r-l);
            }
        }
        return res;
    }
}
