package sorting_searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/task-scheduler/
 * 
 * Task Scheduler:
 * You are given a char array representing tasks CPU need to do. 
 * It contains capital letters A to Z where each letter represents a different task. 
 * Tasks could be done without the original order of the array. Each task is done in one unit of time.
 * For each unit of time, the CPU could complete either one task or just be idle.
 * However, there is a non-negative integer n that represents the cooldown period between 
 * two same tasks (the same letter in the array), that is that there must be at least n units 
 * of time between any two same tasks.
 * You need to return the least number of units of times that the CPU will take to finish 
 * all the given tasks.
 */
public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> map=new HashMap<>();
		for(char c: tasks){
			map.put(c, map.getOrDefault(c,0)+1);
		}
		PriorityQueue<Integer> queue=new PriorityQueue<>(Collections.reverseOrder());
		for(int k: map.values()){
			queue.add(k);
		}
		int count=0;
		while(!queue.isEmpty()){
			int i=0;
			List<Integer> temp=new ArrayList<>();
			while(i<=n){
				if(!queue.isEmpty()){
					int j=queue.poll();
					if(j>1){
						temp.add(j-1);
					}
				}
				count++;
				if(queue.isEmpty() && temp.size()==0){
					break;
				}
				i++;

			}
			for(int j:temp){

				queue.add(j);

			}
		}
		return count;
	}
}
