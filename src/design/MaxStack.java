package design;

import java.util.Stack;

/*
 * https://leetcode.com/problems/max-stack/
 * 
 * Max Stack:
 * Design a max stack that supports push, pop, top, peekMax and popMax.

push(x) -- Push element x onto stack.
pop() -- Remove the element on top of the stack and return it.
top() -- Get the element on the top.
peekMax() -- Retrieve the maximum element in the stack.
popMax() -- Retrieve the maximum element in the stack, and remove it. If you find 
more than one maximum elements, only remove the top-most one.

 */
public class MaxStack {
	Stack<MyStack> stack;
	/** initialize your data structure here. */
	public MaxStack() {
		stack=new Stack<>();
	}

	public void push(int x) {
		if(stack.isEmpty()){
			stack.push(new MyStack(x, x));
		}
		else{
			stack.push(new MyStack(x, Math.max(x, stack.peek().max)));
		}
	}

	public int pop() {
		if(stack.isEmpty()){
			return -1;
		}
		return stack.pop().val;
	}

	public int top() {
		if(stack.isEmpty()){
			return -1;
		}
		return stack.peek().val;
	}

	public int peekMax() {
		if(stack.isEmpty()){
			return -1;
		}
		return stack.peek().max;
	}

	public int popMax() {
		int max=peekMax();
		Stack<MyStack> temp=new Stack<>();
		while(top()!=max){
			temp.push(stack.pop());
		}
		stack.pop();
		while(!temp.isEmpty()){
			MyStack curr=temp.pop();
			curr.max=Math.max(curr.val, (stack.isEmpty()?curr.val:stack.peek().max));
			stack.push(curr);
		}
		return max;
	}

	class MyStack{
		public int max;
		public int val;

		public MyStack(int val, int max){
			this.max=max;
			this.val=val;
		}
	}
}
