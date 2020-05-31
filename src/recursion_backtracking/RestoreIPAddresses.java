package recursion_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/problems/restore-ip-addresses/
 * Restore IP Addresses:
 * Given a string containing only digits, restore it by returning all possible valid IP address 
 * combinations.
 * A valid IP address consists of exactly four integers (each integer is between 0 and 255) 
 * separated by single points.
 */
public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> result=new ArrayList<>();
		LinkedList<String> tokens=new LinkedList<>();
		recurse(-1, 3, s, tokens, result);
		return result;
	}

	private boolean isValid(String token){
		int m=token.length();
		if(m>3){
			return false;
		}
		if(Integer.valueOf(token)>255){
			return false;
		}
		if(token.charAt(0)=='0'){
			return m==1;
		}
		return true;
	}

	private void recurse(int prev, int dots, String s, LinkedList<String> tokens, List<String> result){
		int n=s.length();
		int maxPos=Math.min(n-1, prev+4);
		for(int i=prev+1;i<maxPos;i++){
			String token=s.substring(prev+1, i+1);
			if(isValid(token)){
				tokens.add(token);
				if(dots-1==0){
					String str=s.substring(i+1, n);
					if(isValid(str)){
						tokens.add(str);
						result.add(String.join(".", tokens));
						tokens.removeLast();
					}
				}
				else{
					recurse(i, dots-1, s, tokens, result);
				}

				tokens.removeLast();
			}
		}
	}
}
