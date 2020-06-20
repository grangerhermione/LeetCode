package strings;
/*
 * https://leetcode.com/problems/valid-word-abbreviation/
 * 
 * Valid Word Abbreviation:
 * Given a non-empty string s and an abbreviation abbr, return whether the string matches with the 
 * given abbreviation.

A string such as "word" contains only the following valid abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", 
"2r1", "3d", "w3", "4"]
Notice that only the above abbreviations are valid abbreviations of the string "word". 
Any other string is not a valid abbreviation of "word".
 */
public class ValidWordAbbreviation {
	public boolean validWordAbbreviation(String word, String abbr) {
		int i=0;
		int j=0;
		while(i<word.length() && j<abbr.length()){
			if(word.charAt(i)==abbr.charAt(j)){
				i++;
				j++;
				continue;
			}
			else if(abbr.charAt(j)>'0' && abbr.charAt(j)<='9'){
				int count=0;
				while(j<abbr.length() && abbr.charAt(j)>='0' && abbr.charAt(j)<='9'){
					count=(count*10+(abbr.charAt(j)-'0'));
					j++;
				}
				i+=count;
			}
			else{
				return false;
			}
		}
		if(i==word.length() && j==abbr.length()){
			return true;
		}
		return false;
	}
}
