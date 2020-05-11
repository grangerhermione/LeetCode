package recursion_backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * Letter Combinations of a Phone Number:
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations 
 * that the number could represent.A mapping of digit to letters (just like on the telephone buttons) 
 * is given below. Note that 1 does not map to any letters.
 */
public class LetterCombinationsOfAPhoneNumber {
	public List<String> letterCombinations(String digits) {
		List<String> result=new ArrayList<>();
		Map<Character, String> map=new HashMap<>();
		map.put('2',"abc");
		map.put('3',"def");
		map.put('4',"ghi");
		map.put('5',"jkl");
		map.put('6',"mno");
		map.put('7',"pqrs");
		map.put('8',"tuv");
		map.put('9',"wxyz");
		if (digits == null || digits.length() == 0) {
			return result;
		}
		result.add("");
		for(char ch:digits.toCharArray()){
			String value=map.get(ch);
			List<String> temp=new ArrayList<>();
			for(int i=0;i<result.size();i++){
				for(char v:value.toCharArray()){
					temp.add(result.get(i)+Character.toString(v));
				}
			}
			result.clear();
			result.addAll(temp);

		}

		return result;
	}
}
