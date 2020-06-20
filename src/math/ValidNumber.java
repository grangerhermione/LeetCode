package math;
/*
 * https://leetcode.com/problems/valid-number/
 * 
 * Valid Number:
 * Validate if a given string can be interpreted as a decimal number.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false
 */
public class ValidNumber {
	public boolean isNumber(String s) {
		s = s.trim();
		boolean pointSeen = false;
		boolean eSeen = false;
		boolean numberSeen = false;
		for(int i=0; i<s.length(); i++) {
			if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
				numberSeen = true;
			} else if(s.charAt(i) == '.') {
				if(eSeen || pointSeen)
					return false;
				pointSeen = true;
			} else if(s.charAt(i) == 'e') {
				if(eSeen || !numberSeen)
					return false;
				numberSeen = false;
				eSeen = true;
			} else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
				if(i != 0 && s.charAt(i-1) != 'e')
					return false;
			} else
				return false;
		}
		return numberSeen;
	}
}
