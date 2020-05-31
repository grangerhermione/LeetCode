package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/reorganize-string/
 * Reorganize String:
 * Given a string S, check if the letters can be rearranged so that two characters that are 
 * adjacent to each other are not the same.
 * If possible, output any possible result.  If not possible, return the empty string.
 */
public class ReorganiseString {
	public String reorganizeString(String S) {
		Map<Character, Integer> map=new HashMap<>();
		for(char ch:S.toCharArray()){
			map.put(ch, map.getOrDefault(ch,0)+1);
		}

		PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.count-a.count);
		for(Map.Entry<Character, Integer> entry: map.entrySet()){
			if(entry.getValue()>(S.length()+1)/2){
				return "";
			}
			pq.add(new Pair(entry.getKey(), entry.getValue()));
		}
		StringBuilder sb=new StringBuilder();
		while(pq.size()>=2){
			Pair p1=pq.poll();
			Pair p2=pq.poll();
			sb.append(p1.ch);
			sb.append(p2.ch);
			p1.count--;
			p2.count--;
			if(p1.count>0){
				pq.add(p1);
			}
			if(p2.count>0){
				pq.add(p2);
			}
		}

		if(pq.size()>0){
			sb.append(pq.poll().ch);
		}
		return sb.toString();
	}


}
class Pair{
	char ch;
	int count;
	Pair(char ch, int count){
		this.ch = ch;
		this.count = count;
	}
}
