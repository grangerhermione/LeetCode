package math;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * https://leetcode.com/problems/basic-calculator-iii/
 * 
 * Basic Calculator III:
 * Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, 
non-negative integers and empty spaces .

The expression string contains only non-negative integers, +, -, *, / operators , open 
( and closing parentheses ) and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid. 
All intermediate results will be in the range of [-2147483648, 2147483647].
 */
public class BasicCalculatorIII {
	public int calculate(String s) {
		if (s == null) {
			return 0;
		}    
		Queue<Character> q = new LinkedList<>();
		for (char c : s.toCharArray()) {
			q.offer(c);
		}
		q.offer('+');
		return cal(q);
	}

	private int cal(Queue<Character> q) {
		char sign = '+';
		int num = 0;
		Stack<Integer> stack = new Stack<>();
		while (!q.isEmpty()) {
			char c = q.poll();
			if (c == ' ') {
				continue;
			}
			if (Character.isDigit(c)) {
				num = 10 * num + c - '0';
			} else if (c == '(') {
				num = cal(q);
			} else {
				if (sign == '+') {
					stack.push(num);
				} else if (sign == '-') {
					stack.push(-num);
				} else if (sign == '*') {
					stack.push(stack.pop() * num);
				} else if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				num = 0;
				sign = c;
				if (c == ')') {
					break;
				}
			}
		}
		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		return sum;
	}
}
