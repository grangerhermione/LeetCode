package strings;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/permutation-in-string/
 * Permutation in String:
 * Given two strings s1 and s2, write a function to return true if s2 
 * contains the permutation of s1. In other words, one of the first string's 
 * permutations is the substring of the second string.
 */
public class PermutationInString {
	public boolean checkInclusion(String s1, String s2) {
        Set<Character> map=new HashSet<>();
        for(char ch:s1.toCharArray()){
            map.add(ch);
        }
        
        char arr[]=new char[26];
        for(char ch:s1.toCharArray()){
            arr[ch-'a']++;
        }
        
        for(int i=0;i<s2.length();i++){
            char ch=s2.charAt(i);
            if(map.contains(ch)){
                char str[]=new char[26];
                for(int j=i;j<i+s1.length() && j<s2.length();j++){
                    str[s2.charAt(j)-'a']++;
                }
                if(new String(arr).equals(new String(str))){
                    return true;
                }
            }
        }
        return false;
	}
}
