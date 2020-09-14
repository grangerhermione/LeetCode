package strings;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/partition-labels/
 * 
 * Partition Labels:
 * A string S of lowercase English letters is given. 
 * We want to partition this string into as many parts as possible so that each letter appears 
 * in at most one part, and return a list of integers representing the size of these parts.
 */
public class PartitionLabels {
	public List<Integer> partitionLabels(String S) {
		int last[]=new int[26];
        for(int i=0;i<S.length();i++){
            last[S.charAt(i)-'a']=i;
        }
        int prev=0;
        int j=0;
        List<Integer> count=new ArrayList<>();
        for(int i=0;i<S.length();i++){
            j=Math.max(j, last[S.charAt(i)-'a']);
            if(i==j){
                count.add(j-prev+1);
                prev=j+1;
            }
        }
        return count;
	}
}
