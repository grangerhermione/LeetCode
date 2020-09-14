package math;
/*
 * https://leetcode.com/problems/integer-to-roman/
 * 
 * Integer to Roman:
 * 
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
Given an integer, convert it to a roman numeral. 
Input is guaranteed to be within the range from 1 to 3999.
 */

public class IntegerToRoman {
	public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};    
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<values.length && num>=0;i++){
            while(values[i]<= num){
                num=num-values[i];
                sb.append(symbols[i]);
            }
        }
        
        return sb.toString();
    }
}
