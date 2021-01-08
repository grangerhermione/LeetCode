package strings;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/reorder-data-in-log-files/
 * 
 * Reorder Data in Log Files:
 * You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.
 */
public class ReorderLogFiles {
	public String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs, (a,b)-> {
			String tokens1[]=a.split(" ", 2);
			String tokens2[]=b.split(" ", 2);
			boolean isDigit1 = Character.isDigit(tokens1[1].charAt(0));
			boolean isDigit2 = Character.isDigit(tokens2[1].charAt(0));
			if(!isDigit1 && !isDigit2){
				int cmp = tokens1[1].compareTo(tokens2[1]);
				if(cmp!=0){
					return cmp;
				}
				return tokens1[0].compareTo(tokens2[0]);
			}
			if(isDigit1 && isDigit2){
				return 0;
			}
			if(isDigit1 && !isDigit2){
				return 1;
			}
			else{
				return -1;
			}
		});

		return logs;
	}
}
