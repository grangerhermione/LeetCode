package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * Find All Anagrams in a String:
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p 
 * will not be larger than 20,100.
 */
public class FindAllAnagramsInAString {
	
	public List<Integer> findAnagrams(String s, String p) {
        char [] pArr=new char[26];
        char [] sArr=new char[26];
        for(Character ch: p.toCharArray()){
            pArr[ch-'a']++;
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            sArr[ch-'a']++;
            if(i>=p.length()){
                sArr[s.charAt(i-p.length())-'a']--;
            }
            if(Arrays.equals(sArr, pArr)){
                result.add(i-p.length()+1);
            }
        }
        return result;
    }
	
}
