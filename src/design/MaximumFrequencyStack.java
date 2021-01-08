package design;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * https://leetcode.com/problems/maximum-frequency-stack/
 * 
 * Maximum Frequency Stack:
 * Implement FreqStack, a class which simulates the operation of a stack-like data structure.

FreqStack has two functions:

push(int x), which pushes an integer x onto the stack.
pop(), which removes and returns the most frequent element in the stack.
If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 */
public class MaximumFrequencyStack {
	Map<Integer, Stack<Integer>> map;
	Map<Integer,Integer> freq;
	int max;
	public MaximumFrequencyStack() {
		map=new HashMap<>();
		freq=new HashMap<>();
		max=0;
	}

	public void push(int x) {
		int f=freq.getOrDefault(x, 0)+1;
		freq.put(x, f);
		max=Math.max(max, f);
		if(map.containsKey(f)){
			map.get(f).push(x);
		}
		else{
			Stack<Integer> stack=new Stack<>();
			stack.push(x);
			map.put(f, stack);
		}
	}

	public int pop() {
		int e=map.get(max).pop();
		if(map.get(max).size()==0){
			max--;
		}
		freq.put(e, freq.get(e)-1);
		return e;
	}
}
