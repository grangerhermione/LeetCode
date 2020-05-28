package math;

import java.util.HashMap;

/*
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 * Fraction to Recurring Decimal:
 * Given two integers representing the numerator and denominator of a fraction, 
 * return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 */
public class FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		if(numerator==0){
			return "0";
		}
		if(denominator==0){
			return "";
		}

		String result="";
		if((numerator<0) ^ (denominator<0)){
			result+='-';
		}
		long num=numerator;
		long den=denominator;
		num=Math.abs(num);
		den=Math.abs(den);
		long q=num/den;
		long r=num%den;
		result+=q;
		if(r==0){
			return result;
		}
		result+=".";
		r=r*10;
		HashMap<Long,Integer> map=new HashMap<>();
		while(r!=0){
			if(map.containsKey(r)){
				int b=map.get(r);
				return (result.substring(0,b)+"("+result.substring(b, result.length())+")");
			}
			map.put(r, result.length());
			q=r/den;
			result+=q;
			r=(r%den)*10;
		}
		return result;

	}
}
