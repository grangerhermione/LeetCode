package strings;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/permutation-in-string/
 * Permutation in String:
 * Given two strings s1 and s2, write a function to return true if s2 
 * contains the permutation of s1. In other words, one of the first string's 
 * permutations is the substring of the second string.
 */
public class PermutationInString {
	public boolean checkInclusion(String s1, String s2) {
        int small[]=new int[26];
        for(char ch:s1.toCharArray()){
            small[ch-'a']++;
        }
        int big[]=new int[26];
        int n=s1.length();
        for(int i=0;i<s2.length();i++){
            char ch=s2.charAt(i);
            big[ch-'a']++;
            if(i>=n){
                big[s2.charAt(i-n)-'a']--;
            }
            if(Arrays.equals(small, big)){
                return true;
            }
        }
        return false;
    }
}
