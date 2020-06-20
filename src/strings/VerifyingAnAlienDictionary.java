package strings;

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
	        int index[]=new int[26];
	        for(int i=0;i<order.length();i++){
	            index[order.charAt(i)-'a']=i;
	        }
	        for(int i=0;i<words.length-1;i++){
	            String word1=words[i];
	            String word2=words[i+1];
	            int flag=0;
	            for(int j=0;j<Math.min(word1.length(), word2.length());j++){
	                if(word1.charAt(j)!=word2.charAt(j)){
	                    if(index[word1.charAt(j)-'a']>index[word2.charAt(j)-'a']){
	                        return false;
	                    }
	                    flag=1;
	                    break;
	                }
	            }
	            if(flag==0 && word1.length()>word2.length()){
	                return false;
	            }
	            
	        }
	        return true;
	        
	    }
}
