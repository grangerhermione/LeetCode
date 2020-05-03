/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters 
 * and ignoring cases.
 */

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if(s==null){
			return false;
		}
		s=s.toLowerCase();
		int i=0;
		int j=s.length()-1;
		while(i<j){
			while(i<j && !isValid(s.charAt(i))){
				i++;
			}
			while(i<j && !isValid(s.charAt(j))){
				j--;
			}
			if(s.charAt(i) != s.charAt(j)){
				return false;  
			}
			i++;
			j--;
		}
		return true;
	}

	private boolean isValid(char c){
		return ((c >='a' && c<='z') || (c >='0' && c <='9'));
	}

}
