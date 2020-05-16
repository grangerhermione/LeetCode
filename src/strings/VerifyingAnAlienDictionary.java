package strings;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 * Verifying an Alien Dictionary:
 * In an alien language, surprisingly they also use english lowercase letters, 
 * but possibly in a different order. The order of the alphabet is some permutation of 
 * lowercase letters.
 * Given a sequence of words written in the alien language, 
 * and the order of the alphabet, return true if and only if the 
 * given words are sorted lexicographicaly in this alien language.
 */
public class VerifyingAnAlienDictionary {
	public boolean isAlienSorted(String[] words, String order) {
		Map<Character, Integer> alphabet=new HashMap<>();
		for(int i=0;i<order.length();i++){
			alphabet.put(order.charAt(i),i);
		}

		for(int i=0;i<words.length-1;i++){
			//Compare i and i+1th word
			int j=0;
			int m=words[i].length();
			int n=words[i+1].length();
			int flag=0;
			while(j<m && j<n){
				if(words[i].charAt(j)!=words[i+1].charAt(j)){
					if(alphabet.get(words[i].charAt(j))< alphabet.get(words[i+1].charAt(j))){
						flag=1;
						break; 
					}
					else{
						return false;
					}
				}
				j++;
			}
			if(flag==1){
				continue;
			}
			if(j==m && j==n){
				return true;
			}
			if(j==m){
				return true;
			}
			if(j==n){
				return false;
			}

		}
		return true;
	}
}
