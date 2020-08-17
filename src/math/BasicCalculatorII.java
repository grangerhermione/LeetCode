package math;
/*
 * https://leetcode.com/problems/basic-calculator-ii/
 * Basic Calculator II:
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
 * The integer division should truncate toward zero.
 */
public class BasicCalculatorII {
	public int calculate(String s) {
		int md=-1;
		int sign=1;
		int prev=0;
		int result=0;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(Character.isDigit(ch)){
				int num=ch-'0';
				while(++i<s.length() && Character.isDigit(s.charAt(i))){
					num=num*10+(s.charAt(i)-'0');
				}
				i--;
				if(md==0){
					prev=prev*num;
					md=-1;
				}
				else if(md==1){
					prev=prev/num;
					md=-1;
				}
				else{
					prev=num;
				}
			}
			else if(ch=='*'){
				md=0;
			}
			else if(ch=='/'){
				md=1;
			}
			else if(ch=='+'){
				result=result+sign*prev;
				sign=1;
			}
			else if(ch=='-'){
				result=result+sign*prev;
				sign=-1;
			}
		}
		result=result+sign*prev;
		return result;
	}
}
