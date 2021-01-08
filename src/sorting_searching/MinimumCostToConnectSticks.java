package sorting_searching;

import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/minimum-cost-to-connect-sticks/
 * 
 * Minimum Cost to Connect Sticks:
 * You have some number of sticks with positive integer lengths. 
 * These lengths are given as an array sticks, where sticks[i] is the length of the ith stick.

You can connect any two sticks of lengths x and y into one stick by paying a cost of x + y. 
You must connect all the sticks until there is only one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.

 */
public class MinimumCostToConnectSticks {
	public int connectSticks(int[] sticks) {
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int num:sticks){
			pq.add(num);
		}
		int cost=0;
		while(pq.size()>=2){
			int a=pq.poll();
			int b=pq.poll();
			cost+=a+b;
			pq.add(a+b);
		}
		return cost;
	}
}
