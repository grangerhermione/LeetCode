/*
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
Given a roman numeral, convert it to an integer. 
Input is guaranteed to be within the range from 1 to 3999.
 */

public class RomanToInteger {
	public int romanToInt(String s) {
		int[] nums = new int[s.length()];
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			nums[i] = getRoman(c);
		}
		int sum = 0;
		for(int i=0;i<nums.length-1;i++){
			if(nums[i]<nums[i+1]){
				sum -= nums[i];
			}
			else{
				sum +=nums[i];
			}
		}
		return sum+nums[s.length()-1];
	}

	public int getRoman(char c){
		if(c=='I'){
			return 1;
		}
		else if(c=='V'){
			return 5;
		}
		else if(c=='X'){
			return 10;
		}
		else if(c=='L'){
			return 50;
		}
		else if(c=='C'){
			return 100;
		}
		else if(c=='D'){
			return 500;
		}
		else if(c=='M'){
			return 1000;
		}
		return 0;
	}
}
