package math;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/roman-to-integer/
 * 
 * Roman to Integer:
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
Given a roman numeral, convert it to an integer. 
Input is guaranteed to be within the range from 1 to 3999.
 */

public class RomanToInteger {
	public int romanToInt(String s) {
		Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int result=0;
        for(int i=0;i<s.length()-1;i++){
            if(map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                result-=map.get(s.charAt(i));
            }
            else{
                result+=map.get(s.charAt(i));
            }
        }
        result+=map.get(s.charAt(s.length()-1));
        return result;
	}

}
