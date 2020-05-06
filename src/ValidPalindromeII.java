/*
 * Given a non-empty string s, you may delete at most one character. 
 * Judge whether you can make it a palindrome.
 */

public class ValidPalindromeII {
	public boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<=j && s.charAt(i)==s.charAt(j)){
            i++;
            j--;
        }
        if(i>=j){
            return true;
        }
        
        return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
    }
    
    private boolean isPalindrome(String s, int i, int j){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
}
