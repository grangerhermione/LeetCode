package strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/most-common-word/
 * 
 * Most Common Word:
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the 
 * list of banned words.  It is guaranteed there is at least one word that isn't banned, 
 * and that the answer is unique.
 * Words in the list of banned words are given in lowercase, and free of punctuation.  
 * Words in the paragraph are not case sensitive.  The answer is in lowercase.
 */
public class MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set=new HashSet<>();
        for(String b:banned){
            set.add(b);
        }
        
        paragraph=paragraph.replaceAll("[^a-zA-Z0-9]"," ");
        paragraph=paragraph.toLowerCase();
        String tokens[]=paragraph.split("\\s+");
        Map<String, Integer> wordCount=new HashMap<>();
        for(String str: tokens){
            if(!set.contains(str)){
                wordCount.put(str, wordCount.getOrDefault(str, 0)+1);
            }
        }
        
        return Collections.max(wordCount.entrySet(),Map.Entry.comparingByValue()).getKey();
        
    }
}
