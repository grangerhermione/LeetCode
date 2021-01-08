package design;

import java.util.Stack;

/*
 * https://leetcode.com/problems/min-stack/
 * 
 * Min Stack:
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {
	Stack<MyStack> st;
	/** initialize your data structure here. */
	public MinStack() {
		st=new Stack<>();
	}

	public void push(int x) {
		if(st.isEmpty()){
			st.push(new MyStack(x,x));
		}
		else{
			MyStack n=new MyStack(x, Math.min(x, st.peek().min));
			st.push(n);
		}
	}

	public void pop() {
		if(st.isEmpty()){
			return;
		}
		st.pop();
	}

	public int top() {
		if(st.isEmpty()){
			return -1;
		}
		return st.peek().val;
	}

	public int getMin() {
		if(st.isEmpty()){
			return -1;
		}
		return st.peek().min;
	}
}

class MyStack{
	public int min;
	public int val;

	public MyStack(int val, int min){
		this.min=min;
		this.val=val;
	}
}
