/*

Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the 
first non-whitespace character is found. Then, starting from this character, 
takes an optional initial plus or minus sign followed by as many numerical digits as possible, 
and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, 
which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, 
or if no such sequence exists because either str is empty or it contains only whitespace characters, 
no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit 
signed integer range: [−231,  231 − 1]. 
If the numerical value is out of the range of representable values, INT_MAX (231 − 1) 
or INT_MIN (−231) is returned.

 */

public class StringToIntegerAtoi {
	public int myAtoi(String str) {
		if(str==null || str.length()<1){
			return 0;
		}

		str=str.trim();
		if(str.length()<1){
			return 0;
		}
		int i=0;
		char sign='+';
		if(str.charAt(0)=='-'){
			sign='-';
			i++;
		}
		else if(str.charAt(0)=='+'){
			i++;
		}

		double result=0;
		while(i<str.length() && str.charAt(i)-'0'>=0 && str.charAt(i)-'0'<=9){
			result=result*10+(str.charAt(i)-'0');
			i++;
		}
		if(sign=='-'){
			result=-result;
		}
		if(result<Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}
		if(result>Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}
		return (int)result;
	}
}
