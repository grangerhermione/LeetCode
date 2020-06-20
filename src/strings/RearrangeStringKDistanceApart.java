package strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://leetcode.com/problems/rearrange-string-k-distance-apart/
 * 
 * Rearrange String k Distance Apart:
 * Given a non-empty string s and an integer k, rearrange the string such that the 
 * same characters are at least distance k from each other.
 * All input strings are given in lowercase letters. 
 * If it is not possible to rearrange the string, return an empty string "".
 */
public class RearrangeStringKDistanceApart {
	public String rearrangeString(String s, int k) {
		Map<Character, Integer> map=new HashMap<>();
		for(char ch: s.toCharArray()){
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}

		PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->(b.count-a.count));
		for(Map.Entry<Character, Integer> entry: map.entrySet()){
			pq.add(new Pair(entry.getKey(), entry.getValue()));
		}
		Queue<Pair> waitQueue = new LinkedList<>();

		StringBuilder sb=new StringBuilder();
		while(!pq.isEmpty()){
			Pair p=pq.poll();
			sb.append(p.ch);
			p.count--;
			waitQueue.add(p);

			if (waitQueue.size() < k) {
				continue;
			}

			Pair front = waitQueue.poll();
			if (front.count > 0) {
				pq.offer(front);
			}
		}

		return sb.length() == s.length() ? sb.toString() : "";

	}

	class Pair{
		char ch;
		int count;
		Pair(char ch, int count){
			this.ch=ch;
			this.count=count;
		}
	}
}
